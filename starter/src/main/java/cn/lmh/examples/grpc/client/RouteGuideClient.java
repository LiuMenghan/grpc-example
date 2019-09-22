package cn.lmh.examples.grpc.client;

import cn.lmh.examples.grpc.CallableStreamObserver;
import cn.lmh.examples.grpc.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RouteGuideClient {

    private final ManagedChannel channel;
    private final RouteGuideGrpc.RouteGuideBlockingStub blockingStub;
    private final RouteGuideGrpc.RouteGuideStub asyncStub;

    public RouteGuideClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    /** Construct client for accessing RouteGuide server using the existing channel. */
    public RouteGuideClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = RouteGuideGrpc.newBlockingStub(channel);
        asyncStub = RouteGuideGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public LocationNote getPoint(int lo, int lt, boolean blocking) throws Throwable {
        Point point = Point.newBuilder().setLongitude(lo).setLatitude(lt).build();
        if(blocking) {
            return blockingStub.getPoint(point);
        }else{
            CallableStreamObserver<LocationNote> responseObserver = new CallableStreamObserver<LocationNote>();
            asyncStub.getPoint(point, responseObserver);
            return responseObserver.get().get(0);
        }
    }

    public Iterator<Point> listPoints(int left, int top, int right, int bottom, boolean blocking) throws Throwable {
        Point hi = Point.newBuilder().setLongitude(left).setLatitude(top).build();
        Point lo = Point.newBuilder().setLongitude(right).setLatitude(bottom).build();
        Rectangle rec = Rectangle.newBuilder().setHi(hi).setLo(lo).build();
        if(blocking){
            return blockingStub.listPoints(rec);
        }else{
            CallableStreamObserver<Point> responseObserver = new CallableStreamObserver<Point>();
            asyncStub.listPoints(rec, responseObserver);
            return responseObserver.get().iterator();
        }
    }

    public RouteSummary recordRoute(Collection<Point> points) throws Throwable {
        CallableStreamObserver<RouteSummary> responseObserver = new CallableStreamObserver<RouteSummary>();
        StreamObserver<Point> requestObserver = asyncStub.recordRoute(responseObserver);
        points.stream().parallel().forEach(p -> requestObserver.onNext(p));
        requestObserver.onCompleted();
        return responseObserver.get().get(0);

    }

    public List<RouteSummary> getPointStream(Collection<Point> points) throws Throwable {
        CallableStreamObserver<RouteSummary> responseObserver = new CallableStreamObserver<RouteSummary>();
        StreamObserver<Point> requestObserver = asyncStub.getPointStream(responseObserver);
        points.stream().parallel().forEach(p -> requestObserver.onNext(p));
        requestObserver.onCompleted();
        return responseObserver.get();
    }
}
