package cn.lmh.examples.grpc;

import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.Status;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CuratorNameResolver extends NameResolver {
	CuratorFramework curatorFramework;
	String basePath;
	String serviceAuthority;
	private Listener2 listener;

	public CuratorNameResolver(CuratorFramework curatorFramework, String basePath, String serviceAuthority) {
		this.curatorFramework = curatorFramework;
		this.basePath = basePath;
		this.serviceAuthority = serviceAuthority;
	}

	@Override
	public void start(Listener2 listener) {
		this.curatorFramework.start();
		this.listener = listener;
		refresh();
	}

	@Override
	public void refresh() {
		List<EquivalentAddressGroup> servers = new ArrayList<>();
		try {
			List<EquivalentAddressGroup> addresses = curatorFramework.getChildren()
					.forPath(basePath)
					.stream().map(address ->{
						try {
							URI uri = new URI("http://" + address);
							return new EquivalentAddressGroup(
									new InetSocketAddress(uri.getHost(), uri.getPort()));
						}catch (Exception e){
							listener.onError(Status.INTERNAL);
							return null;
						}
					}).collect(Collectors.toList());
			listener.onResult(ResolutionResult.newBuilder().setAddresses(addresses).build());

		} catch (Exception e) {
			listener.onError(Status.INTERNAL);
		}
	}

	@Override
	public String getServiceAuthority() {
		return this.serviceAuthority;
	}

	@Override
	public void shutdown() {
		this.curatorFramework.close();
	}

	public static class Factory extends NameResolver.Factory{
		@Override
		public NameResolver newNameResolver(URI targetUri, Args args) {
			String address = targetUri.getHost() + ":" + targetUri.getPort();
			String authority = null == targetUri.getAuthority() ? address : targetUri.getAuthority();
			CuratorFramework curator = CuratorFrameworkFactory.builder()
					.connectString(address)
					.retryPolicy(new ExponentialBackoffRetry(1000, 5))
					.connectionTimeoutMs(1000)
					.sessionTimeoutMs(60000)
					.build();
			return new CuratorNameResolver(curator, targetUri.getPath(), authority);
		}

		@Override
		public String getDefaultScheme() {
			return "zookeeper";
		}
	}
}
