package cn.lmh.examples.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: Greeting.proto")
public final class RouteGuideGrpc {

  private RouteGuideGrpc() {}

  public static final String SERVICE_NAME = "RouteGuide";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Point,
      cn.lmh.examples.grpc.proto.LocationNote> getGetPointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPoint",
      requestType = cn.lmh.examples.grpc.proto.Point.class,
      responseType = cn.lmh.examples.grpc.proto.LocationNote.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Point,
      cn.lmh.examples.grpc.proto.LocationNote> getGetPointMethod() {
    io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Point, cn.lmh.examples.grpc.proto.LocationNote> getGetPointMethod;
    if ((getGetPointMethod = RouteGuideGrpc.getGetPointMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getGetPointMethod = RouteGuideGrpc.getGetPointMethod) == null) {
          RouteGuideGrpc.getGetPointMethod = getGetPointMethod =
              io.grpc.MethodDescriptor.<cn.lmh.examples.grpc.proto.Point, cn.lmh.examples.grpc.proto.LocationNote>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getPoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.lmh.examples.grpc.proto.Point.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.lmh.examples.grpc.proto.LocationNote.getDefaultInstance()))
              .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("getPoint"))
              .build();
        }
      }
    }
    return getGetPointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Rectangle,
      cn.lmh.examples.grpc.proto.Point> getListPointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listPoints",
      requestType = cn.lmh.examples.grpc.proto.Rectangle.class,
      responseType = cn.lmh.examples.grpc.proto.Point.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Rectangle,
      cn.lmh.examples.grpc.proto.Point> getListPointsMethod() {
    io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Rectangle, cn.lmh.examples.grpc.proto.Point> getListPointsMethod;
    if ((getListPointsMethod = RouteGuideGrpc.getListPointsMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getListPointsMethod = RouteGuideGrpc.getListPointsMethod) == null) {
          RouteGuideGrpc.getListPointsMethod = getListPointsMethod =
              io.grpc.MethodDescriptor.<cn.lmh.examples.grpc.proto.Rectangle, cn.lmh.examples.grpc.proto.Point>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listPoints"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.lmh.examples.grpc.proto.Rectangle.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.lmh.examples.grpc.proto.Point.getDefaultInstance()))
              .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("listPoints"))
              .build();
        }
      }
    }
    return getListPointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Point,
      cn.lmh.examples.grpc.proto.RouteSummary> getRecordRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "recordRoute",
      requestType = cn.lmh.examples.grpc.proto.Point.class,
      responseType = cn.lmh.examples.grpc.proto.RouteSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Point,
      cn.lmh.examples.grpc.proto.RouteSummary> getRecordRouteMethod() {
    io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Point, cn.lmh.examples.grpc.proto.RouteSummary> getRecordRouteMethod;
    if ((getRecordRouteMethod = RouteGuideGrpc.getRecordRouteMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getRecordRouteMethod = RouteGuideGrpc.getRecordRouteMethod) == null) {
          RouteGuideGrpc.getRecordRouteMethod = getRecordRouteMethod =
              io.grpc.MethodDescriptor.<cn.lmh.examples.grpc.proto.Point, cn.lmh.examples.grpc.proto.RouteSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "recordRoute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.lmh.examples.grpc.proto.Point.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.lmh.examples.grpc.proto.RouteSummary.getDefaultInstance()))
              .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("recordRoute"))
              .build();
        }
      }
    }
    return getRecordRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Point,
      cn.lmh.examples.grpc.proto.RouteSummary> getGetPointStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getPointStream",
      requestType = cn.lmh.examples.grpc.proto.Point.class,
      responseType = cn.lmh.examples.grpc.proto.RouteSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Point,
      cn.lmh.examples.grpc.proto.RouteSummary> getGetPointStreamMethod() {
    io.grpc.MethodDescriptor<cn.lmh.examples.grpc.proto.Point, cn.lmh.examples.grpc.proto.RouteSummary> getGetPointStreamMethod;
    if ((getGetPointStreamMethod = RouteGuideGrpc.getGetPointStreamMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getGetPointStreamMethod = RouteGuideGrpc.getGetPointStreamMethod) == null) {
          RouteGuideGrpc.getGetPointStreamMethod = getGetPointStreamMethod =
              io.grpc.MethodDescriptor.<cn.lmh.examples.grpc.proto.Point, cn.lmh.examples.grpc.proto.RouteSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getPointStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.lmh.examples.grpc.proto.Point.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.lmh.examples.grpc.proto.RouteSummary.getDefaultInstance()))
              .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("getPointStream"))
              .build();
        }
      }
    }
    return getGetPointStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RouteGuideStub newStub(io.grpc.Channel channel) {
    return new RouteGuideStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RouteGuideBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RouteGuideBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RouteGuideFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RouteGuideFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class RouteGuideImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * A simple RPC.
     * </pre>
     */
    public void getPoint(cn.lmh.examples.grpc.proto.Point request,
        io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.LocationNote> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPointMethod(), responseObserver);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * </pre>
     */
    public void listPoints(cn.lmh.examples.grpc.proto.Rectangle request,
        io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.Point> responseObserver) {
      asyncUnimplementedUnaryCall(getListPointsMethod(), responseObserver);
    }

    /**
     * <pre>
     * A client-to-server streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.Point> recordRoute(
        io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.RouteSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(getRecordRouteMethod(), responseObserver);
    }

    /**
     * <pre>
     * A Bidirectional streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.Point> getPointStream(
        io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.RouteSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetPointStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPointMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cn.lmh.examples.grpc.proto.Point,
                cn.lmh.examples.grpc.proto.LocationNote>(
                  this, METHODID_GET_POINT)))
          .addMethod(
            getListPointsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                cn.lmh.examples.grpc.proto.Rectangle,
                cn.lmh.examples.grpc.proto.Point>(
                  this, METHODID_LIST_POINTS)))
          .addMethod(
            getRecordRouteMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                cn.lmh.examples.grpc.proto.Point,
                cn.lmh.examples.grpc.proto.RouteSummary>(
                  this, METHODID_RECORD_ROUTE)))
          .addMethod(
            getGetPointStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                cn.lmh.examples.grpc.proto.Point,
                cn.lmh.examples.grpc.proto.RouteSummary>(
                  this, METHODID_GET_POINT_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideStub extends io.grpc.stub.AbstractStub<RouteGuideStub> {
    private RouteGuideStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * </pre>
     */
    public void getPoint(cn.lmh.examples.grpc.proto.Point request,
        io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.LocationNote> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPointMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * </pre>
     */
    public void listPoints(cn.lmh.examples.grpc.proto.Rectangle request,
        io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.Point> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListPointsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * A client-to-server streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.Point> recordRoute(
        io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.RouteSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getRecordRouteMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * A Bidirectional streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.Point> getPointStream(
        io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.RouteSummary> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetPointStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideBlockingStub extends io.grpc.stub.AbstractStub<RouteGuideBlockingStub> {
    private RouteGuideBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * </pre>
     */
    public cn.lmh.examples.grpc.proto.LocationNote getPoint(cn.lmh.examples.grpc.proto.Point request) {
      return blockingUnaryCall(
          getChannel(), getGetPointMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * </pre>
     */
    public java.util.Iterator<cn.lmh.examples.grpc.proto.Point> listPoints(
        cn.lmh.examples.grpc.proto.Rectangle request) {
      return blockingServerStreamingCall(
          getChannel(), getListPointsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideFutureStub extends io.grpc.stub.AbstractStub<RouteGuideFutureStub> {
    private RouteGuideFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.lmh.examples.grpc.proto.LocationNote> getPoint(
        cn.lmh.examples.grpc.proto.Point request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPointMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_POINT = 0;
  private static final int METHODID_LIST_POINTS = 1;
  private static final int METHODID_RECORD_ROUTE = 2;
  private static final int METHODID_GET_POINT_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RouteGuideImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RouteGuideImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_POINT:
          serviceImpl.getPoint((cn.lmh.examples.grpc.proto.Point) request,
              (io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.LocationNote>) responseObserver);
          break;
        case METHODID_LIST_POINTS:
          serviceImpl.listPoints((cn.lmh.examples.grpc.proto.Rectangle) request,
              (io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.Point>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECORD_ROUTE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recordRoute(
              (io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.RouteSummary>) responseObserver);
        case METHODID_GET_POINT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getPointStream(
              (io.grpc.stub.StreamObserver<cn.lmh.examples.grpc.proto.RouteSummary>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RouteGuideBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RouteGuideBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.lmh.examples.grpc.proto.Greeting.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RouteGuide");
    }
  }

  private static final class RouteGuideFileDescriptorSupplier
      extends RouteGuideBaseDescriptorSupplier {
    RouteGuideFileDescriptorSupplier() {}
  }

  private static final class RouteGuideMethodDescriptorSupplier
      extends RouteGuideBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RouteGuideMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RouteGuideGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RouteGuideFileDescriptorSupplier())
              .addMethod(getGetPointMethod())
              .addMethod(getListPointsMethod())
              .addMethod(getRecordRouteMethod())
              .addMethod(getGetPointStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
