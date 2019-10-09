package cn.lmh.examples.grpc.client;

import cn.lmh.examples.grpc.CallableStreamObserver;
import cn.lmh.examples.grpc.CuratorNameResolver;
import cn.lmh.examples.grpc.RandomLoadBalancer;
import cn.lmh.examples.grpc.proto.GreetingGrpc;
import cn.lmh.examples.grpc.proto.Request;
import io.grpc.LoadBalancerRegistry;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.curator.framework.CuratorFramework;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GreetingClient {

    private final ManagedChannel channel;
    private final GreetingGrpc.GreetingBlockingStub blockingStub;

    public GreetingClient(String host, int port, String path) {
        String target = "zookeeper://" + host + ":" + port + path;
        CuratorNameResolver.Factory factory = new CuratorNameResolver.Factory();

        LoadBalancerRegistry.getDefaultRegistry().register(new RandomLoadBalancer.Provider());
        ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder
                .forTarget(target)
                .nameResolverFactory(factory)
                .defaultLoadBalancingPolicy("random")
                .usePlaintext();
        channel = channelBuilder.build();
        blockingStub = GreetingGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public String sayHello(String name){
        Request request = Request.newBuilder().setName(name).build();
        return blockingStub.sayHello(request).getMessage();
    }
}
