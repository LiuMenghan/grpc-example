package cm.lmh.examples.grpc;

import cn.lmh.examples.grpc.client.RouteGuideClient;
import cn.lmh.examples.grpc.proto.LocationNote;
import cn.lmh.examples.grpc.proto.Point;
import cn.lmh.examples.grpc.proto.RouteSummary;
import cn.lmh.examples.grpc.server.RouteGuideServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RouteGuideTest {
    RouteGuideServer server;
    RouteGuideClient client;
    @Before
    public void init() throws IOException {
        int port = 8081;
        server = new RouteGuideServer(port);
        server.start();
        client = new RouteGuideClient("localhost",port);
    }

    @After
    public void destroy() throws InterruptedException {
        client.shutdown();
        server.stop();
    }

    @Test
    public void getPoint() throws Throwable {
        long t0 = System.nanoTime();
        LocationNote blockingResult = client.getPoint(0, 0, true);
        long t1 = System.nanoTime();
        LocationNote asyncResult = client.getPoint(0, 0, false);
        System.out.println("blocking(" + (t1 - t0) +"):" + blockingResult.toString());
        System.out.println("async(" + (System.nanoTime() - t1) +"):" + asyncResult.toString());
    }

    @Test
    public void listPoints() throws Throwable {
        long t0 = System.nanoTime();
        Iterator<Point> blockingResult = client.listPoints(0, 10, 10,0, true);
        long t1 = System.nanoTime();
        Iterator<Point> asyncResult = client.listPoints(0, 10, 10,0, false);
        System.out.println("blocking(" + (t1 - t0) +"):");
        blockingResult.forEachRemaining(p -> System.out.print(p.toString()));
        System.out.println("async(" + (System.nanoTime() - t1) +"):");
        asyncResult.forEachRemaining(p -> System.out.print(p.toString()));
    }

    @Test
    public void recordRoute() throws Throwable {
        List<Point> points = IntStream.range(0, 100).mapToObj(i ->{
            return Point.newBuilder().setLatitude(i).setLongitude(i).build();
        }).collect(Collectors.toList());
        RouteSummary result = client.recordRoute(points);
        System.out.println(result.toString());
    }

    @Test
    public void getPointStream() throws Throwable {
        List<Point> points = IntStream.range(0, 100).mapToObj(i ->{
            return Point.newBuilder().setLatitude(i).setLongitude(i).build();
        }).collect(Collectors.toList());
        List<RouteSummary> result = client.getPointStream(points);
        result.forEach(p -> System.out.print(p.toString()));
    }
}
