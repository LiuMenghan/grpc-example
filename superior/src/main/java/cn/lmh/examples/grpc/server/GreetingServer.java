package cn.lmh.examples.grpc.server;

import cn.lmh.examples.grpc.proto.GreetingGrpc;
import cn.lmh.examples.grpc.proto.Request;
import cn.lmh.examples.grpc.proto.Response;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.io.IOException;

public class GreetingServer {
	private final int port;
	private final Server server;
	private String registryPath;
	private String address;
	CuratorFramework curator = CuratorFrameworkFactory.builder()
			.connectString("172.16.17.101:2181")
			.retryPolicy(new ExponentialBackoffRetry(1000, 5))
			.connectionTimeoutMs(1000)
			.sessionTimeoutMs(60000)
			.build();;

	public GreetingServer(int port, String registryPath) throws IOException {
		this.port = port;
		server = ServerBuilder.forPort(port).addService(new GreetingService())
				.build();
		this.registryPath = registryPath;
		this.address =  "localhost:" + port;    //本机网卡不能正确显示地址，直接写死localhost
	}

	/**
	 * Start server.
	 */
	public void start() throws Exception {
		this.curator.start();
		server.start();;
		this.curator.create()
				.creatingParentContainersIfNeeded()
				.withMode(CreateMode.EPHEMERAL)
				.forPath(registryPath + "/" + address, ("http://" + address).getBytes());

		System.out.println("Server started, listening on " + address);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				GreetingServer.this.stop();
			}
		});
	}

	/**
	 * Stop server
	 */
	public void stop() {
		if (server != null) {
			server.shutdown();
		}
		if(null != this.curator)
			this.curator.close();
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	private class GreetingService extends GreetingGrpc.GreetingImplBase {
		@Override
		public void sayHello(Request request, StreamObserver<Response> responseObserver) {
			StringBuffer msg = new StringBuffer("Hello, ")
					.append(request.getName())
					.append("! This is ")
					.append(address)
					.append(".");
			Response response = Response.newBuilder().setMessage(msg.toString()).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}
	}
}
