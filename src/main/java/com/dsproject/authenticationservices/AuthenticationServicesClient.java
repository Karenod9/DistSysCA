//package com.dsproject.authenticationservices;
//
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//import io.grpc.stub.StreamObserver;
//
//import java.util.Scanner;
//
//import com.dsproject.authenticationservices.*;
//
//import com.dsproject.authenticationservices.AuthenticationServicesGrpc.AuthenticationServicesBlockingStub;
//import com.dsproject.authenticationservices.AuthenticationServicesGrpc.AuthenticationServicesStub;
//
//public class AuthenticationServicesClient {
//	
//	
//	private static AuthenticationServicesBlockingStub blockingStub;
//	private static AuthenticationServicesStub asyncStub;
//	
//	public static void main(String[] args) {
//		ManagedChannel channel = ManagedChannelBuilder
//				.forAddress("localhost", 9090)
//				.usePlaintext()
//				.build();
//		
//		blockingStub = AuthenticationServicesGrpc.newBlockingStub(channel);
//		asyncStub = AuthenticationServicesGrpc.newStub(channel);
//		
//		login();
//		//logout();
//		
//
//	}
//	
//	public static void login() {
//		String username, password;
//		
//		System.out.println("Enter your username : ");
//		Scanner input = new Scanner(System.in);
//		username = input.nextLine();
//		System.out.println("Enter your password : ");
//		password = input.nextLine();
//		
//		LoginRequest req = LoginRequest.newBuilder()
//				.setUsername(username)
//				.setPassword(password)
//				.build();
//		LoginResponse response = blockingStub.login(req);
//		System.out.println(response.getResponseMessage());
//		System.out.println(response.getResponseCode());
//		
//		
//		input.close();
//	}
//
//}
