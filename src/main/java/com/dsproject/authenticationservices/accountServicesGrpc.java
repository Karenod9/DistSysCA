package com.dsproject.accountservices;

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
    comments = "Source: account.proto")
public final class accountServicesGrpc {

  private accountServicesGrpc() {}

  public static final String SERVICE_NAME = "accountservices.accountServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dsproject.accountservices.LoginRequest,
      com.dsproject.accountservices.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = com.dsproject.accountservices.LoginRequest.class,
      responseType = com.dsproject.accountservices.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dsproject.accountservices.LoginRequest,
      com.dsproject.accountservices.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.dsproject.accountservices.LoginRequest, com.dsproject.accountservices.LoginResponse> getLoginMethod;
    if ((getLoginMethod = accountServicesGrpc.getLoginMethod) == null) {
      synchronized (accountServicesGrpc.class) {
        if ((getLoginMethod = accountServicesGrpc.getLoginMethod) == null) {
          accountServicesGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.dsproject.accountservices.LoginRequest, com.dsproject.accountservices.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "accountservices.accountServices", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.accountservices.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.accountservices.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new accountServicesMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dsproject.accountservices.Empty,
      com.dsproject.accountservices.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = com.dsproject.accountservices.Empty.class,
      responseType = com.dsproject.accountservices.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dsproject.accountservices.Empty,
      com.dsproject.accountservices.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<com.dsproject.accountservices.Empty, com.dsproject.accountservices.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = accountServicesGrpc.getLogoutMethod) == null) {
      synchronized (accountServicesGrpc.class) {
        if ((getLogoutMethod = accountServicesGrpc.getLogoutMethod) == null) {
          accountServicesGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<com.dsproject.accountservices.Empty, com.dsproject.accountservices.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "accountservices.accountServices", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.accountservices.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.accountservices.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new accountServicesMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static accountServicesStub newStub(io.grpc.Channel channel) {
    return new accountServicesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static accountServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new accountServicesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static accountServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new accountServicesFutureStub(channel);
  }

  /**
   */
  public static abstract class accountServicesImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(com.dsproject.accountservices.LoginRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.accountservices.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void logout(com.dsproject.accountservices.Empty request,
        io.grpc.stub.StreamObserver<com.dsproject.accountservices.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dsproject.accountservices.LoginRequest,
                com.dsproject.accountservices.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dsproject.accountservices.Empty,
                com.dsproject.accountservices.LogoutResponse>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   */
  public static final class accountServicesStub extends io.grpc.stub.AbstractStub<accountServicesStub> {
    private accountServicesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accountServicesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accountServicesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accountServicesStub(channel, callOptions);
    }

    /**
     */
    public void login(com.dsproject.accountservices.LoginRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.accountservices.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(com.dsproject.accountservices.Empty request,
        io.grpc.stub.StreamObserver<com.dsproject.accountservices.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class accountServicesBlockingStub extends io.grpc.stub.AbstractStub<accountServicesBlockingStub> {
    private accountServicesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accountServicesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accountServicesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accountServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dsproject.accountservices.LoginResponse login(com.dsproject.accountservices.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dsproject.accountservices.LogoutResponse logout(com.dsproject.accountservices.Empty request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class accountServicesFutureStub extends io.grpc.stub.AbstractStub<accountServicesFutureStub> {
    private accountServicesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accountServicesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accountServicesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accountServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dsproject.accountservices.LoginResponse> login(
        com.dsproject.accountservices.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dsproject.accountservices.LogoutResponse> logout(
        com.dsproject.accountservices.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final accountServicesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(accountServicesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((com.dsproject.accountservices.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.dsproject.accountservices.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((com.dsproject.accountservices.Empty) request,
              (io.grpc.stub.StreamObserver<com.dsproject.accountservices.LogoutResponse>) responseObserver);
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

  private static abstract class accountServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    accountServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dsproject.accountservices.AccountServicesImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("accountServices");
    }
  }

  private static final class accountServicesFileDescriptorSupplier
      extends accountServicesBaseDescriptorSupplier {
    accountServicesFileDescriptorSupplier() {}
  }

  private static final class accountServicesMethodDescriptorSupplier
      extends accountServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    accountServicesMethodDescriptorSupplier(String methodName) {
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
      synchronized (accountServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new accountServicesFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
