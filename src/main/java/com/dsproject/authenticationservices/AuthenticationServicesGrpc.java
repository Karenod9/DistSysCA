package com.dsproject.authenticationservices;

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
public final class AuthenticationServicesGrpc {

  private AuthenticationServicesGrpc() {}

  public static final String SERVICE_NAME = "authenticationservices.AuthenticationServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dsproject.authenticationservices.LoginRequest,
      com.dsproject.authenticationservices.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = com.dsproject.authenticationservices.LoginRequest.class,
      responseType = com.dsproject.authenticationservices.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dsproject.authenticationservices.LoginRequest,
      com.dsproject.authenticationservices.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.dsproject.authenticationservices.LoginRequest, com.dsproject.authenticationservices.LoginResponse> getLoginMethod;
    if ((getLoginMethod = AuthenticationServicesGrpc.getLoginMethod) == null) {
      synchronized (AuthenticationServicesGrpc.class) {
        if ((getLoginMethod = AuthenticationServicesGrpc.getLoginMethod) == null) {
          AuthenticationServicesGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.dsproject.authenticationservices.LoginRequest, com.dsproject.authenticationservices.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "authenticationservices.AuthenticationServices", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.authenticationservices.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.authenticationservices.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthenticationServicesMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dsproject.authenticationservices.LogoutRequest,
      com.dsproject.authenticationservices.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = com.dsproject.authenticationservices.LogoutRequest.class,
      responseType = com.dsproject.authenticationservices.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dsproject.authenticationservices.LogoutRequest,
      com.dsproject.authenticationservices.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<com.dsproject.authenticationservices.LogoutRequest, com.dsproject.authenticationservices.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = AuthenticationServicesGrpc.getLogoutMethod) == null) {
      synchronized (AuthenticationServicesGrpc.class) {
        if ((getLogoutMethod = AuthenticationServicesGrpc.getLogoutMethod) == null) {
          AuthenticationServicesGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<com.dsproject.authenticationservices.LogoutRequest, com.dsproject.authenticationservices.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "authenticationservices.AuthenticationServices", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.authenticationservices.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.authenticationservices.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthenticationServicesMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthenticationServicesStub newStub(io.grpc.Channel channel) {
    return new AuthenticationServicesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthenticationServicesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuthenticationServicesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthenticationServicesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthenticationServicesFutureStub(channel);
  }

  /**
   */
  public static abstract class AuthenticationServicesImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(com.dsproject.authenticationservices.LoginRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.authenticationservices.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void logout(com.dsproject.authenticationservices.LogoutRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.authenticationservices.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dsproject.authenticationservices.LoginRequest,
                com.dsproject.authenticationservices.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dsproject.authenticationservices.LogoutRequest,
                com.dsproject.authenticationservices.LogoutResponse>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   */
  public static final class AuthenticationServicesStub extends io.grpc.stub.AbstractStub<AuthenticationServicesStub> {
    private AuthenticationServicesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthenticationServicesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticationServicesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthenticationServicesStub(channel, callOptions);
    }

    /**
     */
    public void login(com.dsproject.authenticationservices.LoginRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.authenticationservices.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(com.dsproject.authenticationservices.LogoutRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.authenticationservices.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthenticationServicesBlockingStub extends io.grpc.stub.AbstractStub<AuthenticationServicesBlockingStub> {
    private AuthenticationServicesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthenticationServicesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticationServicesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthenticationServicesBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dsproject.authenticationservices.LoginResponse login(com.dsproject.authenticationservices.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.dsproject.authenticationservices.LogoutResponse logout(com.dsproject.authenticationservices.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthenticationServicesFutureStub extends io.grpc.stub.AbstractStub<AuthenticationServicesFutureStub> {
    private AuthenticationServicesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthenticationServicesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticationServicesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthenticationServicesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dsproject.authenticationservices.LoginResponse> login(
        com.dsproject.authenticationservices.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dsproject.authenticationservices.LogoutResponse> logout(
        com.dsproject.authenticationservices.LogoutRequest request) {
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
    private final AuthenticationServicesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthenticationServicesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((com.dsproject.authenticationservices.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.dsproject.authenticationservices.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((com.dsproject.authenticationservices.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<com.dsproject.authenticationservices.LogoutResponse>) responseObserver);
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

  private static abstract class AuthenticationServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthenticationServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dsproject.authenticationservices.AuthenticationServicesImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthenticationServices");
    }
  }

  private static final class AuthenticationServicesFileDescriptorSupplier
      extends AuthenticationServicesBaseDescriptorSupplier {
    AuthenticationServicesFileDescriptorSupplier() {}
  }

  private static final class AuthenticationServicesMethodDescriptorSupplier
      extends AuthenticationServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthenticationServicesMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthenticationServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthenticationServicesFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
