package com.dsproject.employeeexpenseservice;

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
    comments = "Source: employee_expense_service.proto")
public final class EmployeeExpenseServiceGrpc {

  private EmployeeExpenseServiceGrpc() {}

  public static final String SERVICE_NAME = "employeeexpenseservice.EmployeeExpenseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.AddExpenseClaimRequest,
      com.dsproject.employeeexpenseservice.AddExpenseClaimResponse> getAddExpenseClaimMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addExpenseClaim",
      requestType = com.dsproject.employeeexpenseservice.AddExpenseClaimRequest.class,
      responseType = com.dsproject.employeeexpenseservice.AddExpenseClaimResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.AddExpenseClaimRequest,
      com.dsproject.employeeexpenseservice.AddExpenseClaimResponse> getAddExpenseClaimMethod() {
    io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.AddExpenseClaimRequest, com.dsproject.employeeexpenseservice.AddExpenseClaimResponse> getAddExpenseClaimMethod;
    if ((getAddExpenseClaimMethod = EmployeeExpenseServiceGrpc.getAddExpenseClaimMethod) == null) {
      synchronized (EmployeeExpenseServiceGrpc.class) {
        if ((getAddExpenseClaimMethod = EmployeeExpenseServiceGrpc.getAddExpenseClaimMethod) == null) {
          EmployeeExpenseServiceGrpc.getAddExpenseClaimMethod = getAddExpenseClaimMethod = 
              io.grpc.MethodDescriptor.<com.dsproject.employeeexpenseservice.AddExpenseClaimRequest, com.dsproject.employeeexpenseservice.AddExpenseClaimResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "employeeexpenseservice.EmployeeExpenseService", "addExpenseClaim"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.employeeexpenseservice.AddExpenseClaimRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.employeeexpenseservice.AddExpenseClaimResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmployeeExpenseServiceMethodDescriptorSupplier("addExpenseClaim"))
                  .build();
          }
        }
     }
     return getAddExpenseClaimMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.AddMultiExpenseClaimRequest,
      com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse> getAddMultiExpenseClaimMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addMultiExpenseClaim",
      requestType = com.dsproject.employeeexpenseservice.AddMultiExpenseClaimRequest.class,
      responseType = com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.AddMultiExpenseClaimRequest,
      com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse> getAddMultiExpenseClaimMethod() {
    io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.AddMultiExpenseClaimRequest, com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse> getAddMultiExpenseClaimMethod;
    if ((getAddMultiExpenseClaimMethod = EmployeeExpenseServiceGrpc.getAddMultiExpenseClaimMethod) == null) {
      synchronized (EmployeeExpenseServiceGrpc.class) {
        if ((getAddMultiExpenseClaimMethod = EmployeeExpenseServiceGrpc.getAddMultiExpenseClaimMethod) == null) {
          EmployeeExpenseServiceGrpc.getAddMultiExpenseClaimMethod = getAddMultiExpenseClaimMethod = 
              io.grpc.MethodDescriptor.<com.dsproject.employeeexpenseservice.AddMultiExpenseClaimRequest, com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "employeeexpenseservice.EmployeeExpenseService", "addMultiExpenseClaim"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.employeeexpenseservice.AddMultiExpenseClaimRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmployeeExpenseServiceMethodDescriptorSupplier("addMultiExpenseClaim"))
                  .build();
          }
        }
     }
     return getAddMultiExpenseClaimMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.UploadExpenseReceiptsRequest,
      com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse> getUploadExpenseReceiptsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "uploadExpenseReceipts",
      requestType = com.dsproject.employeeexpenseservice.UploadExpenseReceiptsRequest.class,
      responseType = com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.UploadExpenseReceiptsRequest,
      com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse> getUploadExpenseReceiptsMethod() {
    io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.UploadExpenseReceiptsRequest, com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse> getUploadExpenseReceiptsMethod;
    if ((getUploadExpenseReceiptsMethod = EmployeeExpenseServiceGrpc.getUploadExpenseReceiptsMethod) == null) {
      synchronized (EmployeeExpenseServiceGrpc.class) {
        if ((getUploadExpenseReceiptsMethod = EmployeeExpenseServiceGrpc.getUploadExpenseReceiptsMethod) == null) {
          EmployeeExpenseServiceGrpc.getUploadExpenseReceiptsMethod = getUploadExpenseReceiptsMethod = 
              io.grpc.MethodDescriptor.<com.dsproject.employeeexpenseservice.UploadExpenseReceiptsRequest, com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "employeeexpenseservice.EmployeeExpenseService", "uploadExpenseReceipts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.employeeexpenseservice.UploadExpenseReceiptsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmployeeExpenseServiceMethodDescriptorSupplier("uploadExpenseReceipts"))
                  .build();
          }
        }
     }
     return getUploadExpenseReceiptsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest,
      com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse> getCheckExpenseClaimMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkExpenseClaim",
      requestType = com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest.class,
      responseType = com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest,
      com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse> getCheckExpenseClaimMethod() {
    io.grpc.MethodDescriptor<com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest, com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse> getCheckExpenseClaimMethod;
    if ((getCheckExpenseClaimMethod = EmployeeExpenseServiceGrpc.getCheckExpenseClaimMethod) == null) {
      synchronized (EmployeeExpenseServiceGrpc.class) {
        if ((getCheckExpenseClaimMethod = EmployeeExpenseServiceGrpc.getCheckExpenseClaimMethod) == null) {
          EmployeeExpenseServiceGrpc.getCheckExpenseClaimMethod = getCheckExpenseClaimMethod = 
              io.grpc.MethodDescriptor.<com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest, com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "employeeexpenseservice.EmployeeExpenseService", "checkExpenseClaim"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmployeeExpenseServiceMethodDescriptorSupplier("checkExpenseClaim"))
                  .build();
          }
        }
     }
     return getCheckExpenseClaimMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmployeeExpenseServiceStub newStub(io.grpc.Channel channel) {
    return new EmployeeExpenseServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmployeeExpenseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EmployeeExpenseServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmployeeExpenseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EmployeeExpenseServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EmployeeExpenseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addExpenseClaim(com.dsproject.employeeexpenseservice.AddExpenseClaimRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.AddExpenseClaimResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddExpenseClaimMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.AddMultiExpenseClaimRequest> addMultiExpenseClaim(
        io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAddMultiExpenseClaimMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.UploadExpenseReceiptsRequest> uploadExpenseReceipts(
        io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUploadExpenseReceiptsMethod(), responseObserver);
    }

    /**
     */
    public void checkExpenseClaim(com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckExpenseClaimMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddExpenseClaimMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dsproject.employeeexpenseservice.AddExpenseClaimRequest,
                com.dsproject.employeeexpenseservice.AddExpenseClaimResponse>(
                  this, METHODID_ADD_EXPENSE_CLAIM)))
          .addMethod(
            getAddMultiExpenseClaimMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.dsproject.employeeexpenseservice.AddMultiExpenseClaimRequest,
                com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse>(
                  this, METHODID_ADD_MULTI_EXPENSE_CLAIM)))
          .addMethod(
            getUploadExpenseReceiptsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.dsproject.employeeexpenseservice.UploadExpenseReceiptsRequest,
                com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse>(
                  this, METHODID_UPLOAD_EXPENSE_RECEIPTS)))
          .addMethod(
            getCheckExpenseClaimMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest,
                com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse>(
                  this, METHODID_CHECK_EXPENSE_CLAIM)))
          .build();
    }
  }

  /**
   */
  public static final class EmployeeExpenseServiceStub extends io.grpc.stub.AbstractStub<EmployeeExpenseServiceStub> {
    private EmployeeExpenseServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeExpenseServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeExpenseServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeExpenseServiceStub(channel, callOptions);
    }

    /**
     */
    public void addExpenseClaim(com.dsproject.employeeexpenseservice.AddExpenseClaimRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.AddExpenseClaimResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddExpenseClaimMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.AddMultiExpenseClaimRequest> addMultiExpenseClaim(
        io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAddMultiExpenseClaimMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.UploadExpenseReceiptsRequest> uploadExpenseReceipts(
        io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUploadExpenseReceiptsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void checkExpenseClaim(com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest request,
        io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCheckExpenseClaimMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EmployeeExpenseServiceBlockingStub extends io.grpc.stub.AbstractStub<EmployeeExpenseServiceBlockingStub> {
    private EmployeeExpenseServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeExpenseServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeExpenseServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeExpenseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dsproject.employeeexpenseservice.AddExpenseClaimResponse addExpenseClaim(com.dsproject.employeeexpenseservice.AddExpenseClaimRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddExpenseClaimMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse> checkExpenseClaim(
        com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getCheckExpenseClaimMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EmployeeExpenseServiceFutureStub extends io.grpc.stub.AbstractStub<EmployeeExpenseServiceFutureStub> {
    private EmployeeExpenseServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeExpenseServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeExpenseServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeExpenseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dsproject.employeeexpenseservice.AddExpenseClaimResponse> addExpenseClaim(
        com.dsproject.employeeexpenseservice.AddExpenseClaimRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddExpenseClaimMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_EXPENSE_CLAIM = 0;
  private static final int METHODID_CHECK_EXPENSE_CLAIM = 1;
  private static final int METHODID_ADD_MULTI_EXPENSE_CLAIM = 2;
  private static final int METHODID_UPLOAD_EXPENSE_RECEIPTS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmployeeExpenseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmployeeExpenseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_EXPENSE_CLAIM:
          serviceImpl.addExpenseClaim((com.dsproject.employeeexpenseservice.AddExpenseClaimRequest) request,
              (io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.AddExpenseClaimResponse>) responseObserver);
          break;
        case METHODID_CHECK_EXPENSE_CLAIM:
          serviceImpl.checkExpenseClaim((com.dsproject.employeeexpenseservice.CheckExpenseClaimRequest) request,
              (io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.CheckExpenseClaimResponse>) responseObserver);
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
        case METHODID_ADD_MULTI_EXPENSE_CLAIM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addMultiExpenseClaim(
              (io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.AddMultiExpenseClaimResponse>) responseObserver);
        case METHODID_UPLOAD_EXPENSE_RECEIPTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadExpenseReceipts(
              (io.grpc.stub.StreamObserver<com.dsproject.employeeexpenseservice.UploadExpenseReceiptsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EmployeeExpenseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmployeeExpenseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dsproject.employeeexpenseservice.EmployeeExpenseServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmployeeExpenseService");
    }
  }

  private static final class EmployeeExpenseServiceFileDescriptorSupplier
      extends EmployeeExpenseServiceBaseDescriptorSupplier {
    EmployeeExpenseServiceFileDescriptorSupplier() {}
  }

  private static final class EmployeeExpenseServiceMethodDescriptorSupplier
      extends EmployeeExpenseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EmployeeExpenseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EmployeeExpenseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmployeeExpenseServiceFileDescriptorSupplier())
              .addMethod(getAddExpenseClaimMethod())
              .addMethod(getAddMultiExpenseClaimMethod())
              .addMethod(getUploadExpenseReceiptsMethod())
              .addMethod(getCheckExpenseClaimMethod())
              .build();
        }
      }
    }
    return result;
  }
}
