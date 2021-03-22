package com.dsproject.accountservices;

import com.dsproject.accountservices.accountServicesGrpc.accountServicesImplBase;

import io.grpc.stub.StreamObserver;

public class AccountServices extends accountServicesImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		
		System.out.println("Inside login");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		LoginResponse.Builder response = LoginResponse.newBuilder();
		if(username.equals(password)) {
			//success message
			
			response.setResponseCode(0).setResponseMessage("SUCCESS");
		}
		else {
			response.setResponseCode(100).setResponseMessage("INVALID PASSWORD");
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
		
	}

	@Override
	public void logout(Empty request, StreamObserver<LogoutResponse> responseObserver) {
		
	}
	

}
