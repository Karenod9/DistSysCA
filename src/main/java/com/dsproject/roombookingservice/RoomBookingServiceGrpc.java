package com.dsproject.roombookingservice;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: roombookingservice.proto")
public final class RoomBookingServiceGrpc {

  private RoomBookingServiceGrpc() {}

  public static final String SERVICE_NAME = "roombookingservice.RoomBookingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dsproject.roombookingservice.CheckAvailableRoomsRequest,
      com.dsproject.roombookingservice.CheckAvailableRoomsResponse> getCheckAvailableRoomsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkAvailableRooms",
      requestType = com.dsproject.roombookingservice.CheckAvailableRoomsRequest.class,
      responseType = com.dsproject.roombookingservice.CheckAvailableRoomsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.dsproject.roombookingservice.CheckAvailableRoomsRequest,
      com.dsproject.roombookingservice.CheckAvailableRoomsResponse> getCheckAvailableRoomsMethod() {
    io.grpc.MethodDescriptor<com.dsproject.roombookingservice.CheckAvailableRoomsRequest, com.dsproject.roombookingservice.CheckAvailableRoomsResponse> getCheckAvailableRoomsMethod;
    if ((getCheckAvailableRoomsMethod = RoomBookingServiceGrpc.getCheckAvailableRoomsMethod) == null) {
      synchronized (RoomBookingServiceGrpc.class) {
        if ((getCheckAvailableRoomsMethod = RoomBookingServiceGrpc.getCheckAvailableRoomsMethod) == null) {
          RoomBookingServiceGrpc.getCheckAvailableRoomsMethod = getCheckAvailableRoomsMethod = 
              io.grpc.MethodDescriptor.<com.dsproject.roombookingservice.CheckAvailableRoomsRequest, com.dsproject.roombookingservice.CheckAvailableRoomsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "roombookingservice.RoomBookingService", "checkAvailableRooms"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.roombookingservice.CheckAvailableRoomsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.roombookingservice.CheckAvailableRoomsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RoomBookingServiceMethodDescriptorSupplier("checkAvailableRooms"))
                  .build();
          }
        }
     }
     return getCheckAvailableRoomsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dsproject.roombookingservice.BookRoomRequest,
      com.dsproject.roombookingservice.BookRoomResponse> getBookRoomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookRoom",
      requestType = com.dsproject.roombookingservice.BookRoomRequest.class,
      responseType = com.dsproject.roombookingservice.BookRoomResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dsproject.roombookingservice.BookRoomRequest,
      com.dsproject.roombookingservice.BookRoomResponse> getBookRoomMethod() {
    io.grpc.MethodDescriptor<com.dsproject.roombookingservice.BookRoomRequest, com.dsproject.roombookingservice.BookRoomResponse> getBookRoomMethod;
    if ((getBookRoomMethod = RoomBookingServiceGrpc.getBookRoomMethod) == null) {
      synchronized (RoomBookingServiceGrpc.class) {
        if ((getBookRoomMethod = RoomBookingServiceGrpc.getBookRoomMethod) == null) {
          RoomBookingServiceGrpc.getBookRoomMethod = getBookRoomMethod = 
              io.grpc.MethodDescriptor.<com.dsproject.roombookingservice.BookRoomRequest, com.dsproject.roombookingservice.BookRoomResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "roombookingservice.RoomBookingService", "bookRoom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.roombookingservice.BookRoomRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.roombookingservice.BookRoomResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RoomBookingServiceMethodDescriptorSupplier("bookRoom"))
                  .build();
          }
        }
     }
     return getBookRoomMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoomBookingServiceStub newStub(io.grpc.Channel channel) {
    return new RoomBookingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoomBookingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RoomBookingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoomBookingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RoomBookingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RoomBookingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkAvailableRooms(com.dsproject.roombookingservice.CheckAvailableRoomsRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.roombookingservice.CheckAvailableRoomsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckAvailableRoomsMethod(), responseObserver);
    }

    /**
     */
    public void bookRoom(com.dsproject.roombookingservice.BookRoomRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.roombookingservice.BookRoomResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBookRoomMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckAvailableRoomsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.dsproject.roombookingservice.CheckAvailableRoomsRequest,
                com.dsproject.roombookingservice.CheckAvailableRoomsResponse>(
                  this, METHODID_CHECK_AVAILABLE_ROOMS)))
          .addMethod(
            getBookRoomMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dsproject.roombookingservice.BookRoomRequest,
                com.dsproject.roombookingservice.BookRoomResponse>(
                  this, METHODID_BOOK_ROOM)))
          .build();
    }
  }

  /**
   */
  public static final class RoomBookingServiceStub extends io.grpc.stub.AbstractStub<RoomBookingServiceStub> {
    private RoomBookingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomBookingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomBookingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomBookingServiceStub(channel, callOptions);
    }

    /**
     */
    public void checkAvailableRooms(com.dsproject.roombookingservice.CheckAvailableRoomsRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.roombookingservice.CheckAvailableRoomsResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCheckAvailableRoomsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void bookRoom(com.dsproject.roombookingservice.BookRoomRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.roombookingservice.BookRoomResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBookRoomMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RoomBookingServiceBlockingStub extends io.grpc.stub.AbstractStub<RoomBookingServiceBlockingStub> {
    private RoomBookingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomBookingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomBookingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomBookingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.dsproject.roombookingservice.CheckAvailableRoomsResponse> checkAvailableRooms(
        com.dsproject.roombookingservice.CheckAvailableRoomsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getCheckAvailableRoomsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dsproject.roombookingservice.BookRoomResponse bookRoom(com.dsproject.roombookingservice.BookRoomRequest request) {
      return blockingUnaryCall(
          getChannel(), getBookRoomMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RoomBookingServiceFutureStub extends io.grpc.stub.AbstractStub<RoomBookingServiceFutureStub> {
    private RoomBookingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomBookingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomBookingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomBookingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dsproject.roombookingservice.BookRoomResponse> bookRoom(
        com.dsproject.roombookingservice.BookRoomRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBookRoomMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_AVAILABLE_ROOMS = 0;
  private static final int METHODID_BOOK_ROOM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RoomBookingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RoomBookingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_AVAILABLE_ROOMS:
          serviceImpl.checkAvailableRooms((com.dsproject.roombookingservice.CheckAvailableRoomsRequest) request,
              (io.grpc.stub.StreamObserver<com.dsproject.roombookingservice.CheckAvailableRoomsResponse>) responseObserver);
          break;
        case METHODID_BOOK_ROOM:
          serviceImpl.bookRoom((com.dsproject.roombookingservice.BookRoomRequest) request,
              (io.grpc.stub.StreamObserver<com.dsproject.roombookingservice.BookRoomResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RoomBookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoomBookingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dsproject.roombookingservice.RoomBookingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RoomBookingService");
    }
  }

  private static final class RoomBookingServiceFileDescriptorSupplier
      extends RoomBookingServiceBaseDescriptorSupplier {
    RoomBookingServiceFileDescriptorSupplier() {}
  }

  private static final class RoomBookingServiceMethodDescriptorSupplier
      extends RoomBookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RoomBookingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RoomBookingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoomBookingServiceFileDescriptorSupplier())
              .addMethod(getCheckAvailableRoomsMethod())
              .addMethod(getBookRoomMethod())
              .build();
        }
      }
    }
    return result;
  }
}
