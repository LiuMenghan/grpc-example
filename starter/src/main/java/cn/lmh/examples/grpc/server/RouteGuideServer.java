package cn.lmh.examples.grpc.server;

import cn.lmh.examples.grpc.proto.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class RouteGuideServer {
	private final int port;
	private final Server server;

	public RouteGuideServer(int port) throws IOException {
		this.port = port;
		server = ServerBuilder.forPort(port).addService(new RouteGuideService())
				.build();
	}

	/**
	 * Start server.
	 */
	public void start() throws IOException {
		server.start();
		System.out.println("Server started, listening on " + port);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				RouteGuideServer.this.stop();
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
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	public static void main(String[] args) throws Exception {
		RouteGuideServer server = new RouteGuideServer(8980);
		server.start();
		server.blockUntilShutdown();
	}

	private static class RouteGuideService extends RouteGuideGrpc.RouteGuideImplBase {
		@Override
		public void getPoint(Point request, StreamObserver<LocationNote> responseObserver) {
			LocationNote value = LocationNote.newBuilder()
                    .setLocation(request)
                    .setTimestamp(System.nanoTime())
                    .build();
			responseObserver.onNext(value);
			responseObserver.onCompleted();
		}

		@Override
		public void listPoints(Rectangle request, StreamObserver<Point> responseObserver) {
			int left = Math.min(request.getLo().getLongitude(), request.getHi().getLongitude());
			int right = Math.max(request.getLo().getLongitude(), request.getHi().getLongitude());
			int top = Math.max(request.getLo().getLatitude(), request.getHi().getLatitude());
			int bottom = Math.max(request.getLo().getLatitude(), request.getHi().getLatitude());
			for (int x = left; x <= right; x++) {
				for (int y = top; y >= bottom; y--) {
					Point point = Point.newBuilder().setLongitude(x).setLatitude(y).build();
					responseObserver.onNext(point);
				}
			}
			responseObserver.onCompleted();
		}

		@Override
		public StreamObserver<Point> recordRoute(StreamObserver<RouteSummary> responseObserver) {
			return new StreamObserver<Point>() { //返回的是requestObserver
				AtomicInteger pointCount = new AtomicInteger(0);
				final long startTime = System.nanoTime();

				@Override
				public void onNext(Point value) {
					int count = pointCount.incrementAndGet();
				}

				@Override
				public void onError(Throwable t) {
				}

				@Override
				public void onCompleted() {
					RouteSummary result = RouteSummary.newBuilder().setElapsedTime(System.nanoTime() - startTime).setPointCount(pointCount.get()).build();
					responseObserver.onNext(result);
					responseObserver.onCompleted();
				}
			};
		}

		@Override
		public StreamObserver<Point> getPointStream(StreamObserver<RouteSummary> responseObserver) {
			return new StreamObserver<Point>() { //返回的是requestObserver
				AtomicInteger pointCount = new AtomicInteger(0);
				final long startTime = System.nanoTime();

				@Override
				public void onNext(Point value) {
					int count = pointCount.incrementAndGet();
					RouteSummary result = RouteSummary.newBuilder().setElapsedTime(System.nanoTime() - startTime).setPointCount(count).build();
					responseObserver.onNext(result);
				}

				@Override
				public void onError(Throwable t) {
				}

				@Override
				public void onCompleted() {
					responseObserver.onCompleted();
				}
			};
		}
	}
}
