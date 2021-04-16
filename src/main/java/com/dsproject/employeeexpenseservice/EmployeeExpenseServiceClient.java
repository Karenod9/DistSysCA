package com.dsproject.employeeexpenseservice;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.dsproject.employeeexpenseservice.EmployeeExpenseServiceGrpc.EmployeeExpenseServiceBlockingStub;
import com.dsproject.employeeexpenseservice.EmployeeExpenseServiceGrpc.EmployeeExpenseServiceStub;
import com.google.protobuf.ByteString;

public class EmployeeExpenseServiceClient {
	
	private static EmployeeExpenseServiceBlockingStub blockingStub;
	private static EmployeeExpenseServiceStub asyncStub;

	public static void main(String[] args) throws IOException  {
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 9090)
				.usePlaintext()
				.build();
		
		blockingStub = EmployeeExpenseServiceGrpc.newBlockingStub(channel);
		asyncStub = EmployeeExpenseServiceGrpc.newStub(channel);
		
//		addExpenseClaim();
//		addMultiExpenseClaim();
//		uploadExpenseReceipts();
		//checkExpenseClaimAsync();
		checkExpenseClaimBlocking();
		

	}
	public static void addExpenseClaim() {
		String department, expenseType;
		int expenseClaimNo;
		double totalAmt = 10.00;
		
		department = "Marketing";
		expenseType = "Stationary";
		
		Random ran = new Random();
		expenseClaimNo = ran.nextInt();
		
		AddExpenseClaimRequest req = AddExpenseClaimRequest.newBuilder()
				.setExpenseClaimNo(expenseClaimNo)
				.setDepartment(department)
				.setExpenseType(expenseType)
				.setTotalAmt(totalAmt)
				.build();
		AddExpenseClaimResponse response = blockingStub.addExpenseClaim(req);
		try {
			Thread.sleep(1000);
			System.out.println(response.getClaimResult());
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addMultiExpenseClaim() {
		//final CountDownLatch finishLatch = new CountDownLatch(1);
		StreamObserver<AddMultiExpenseClaimResponse> responseObserver = new StreamObserver <AddMultiExpenseClaimResponse>() {
			int count = 0;
			double runningTotal = 0.0;
			
			@Override
			public void onNext(AddMultiExpenseClaimResponse res) {
				try {
					runningTotal = res.getRunningTotal();
					Thread.sleep(0);
					System.out.println("Sending expense claim : " + "Total amount sent : "+ runningTotal);
					System.out.println(res.getClaimResult());
					count += 1;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			
			@Override
			public void onError(Throwable t) {
				System.out.println("ERROR - Client=side - multi-expense");
				t.printStackTrace();
				//finishLatch.countDown();
			}
			
			@Override
			public void onCompleted() {
				System.out.println("Expenses sent!");
				System.out.println("... received " + count + " expense requests" + " Total amount sent : " + runningTotal);
				//finishLatch.countDown();
			}
		};
		
		StreamObserver<AddMultiExpenseClaimRequest> requestObserver = asyncStub.addMultiExpenseClaim(responseObserver);
		
		String department, expenseType;
		int expenseClaimNo;
		
		Random ran = new Random();
		expenseClaimNo = ran.nextInt();
		Scanner input = new Scanner(System.in);
		
		double num;
		int addNum = 0;
		try {
			do {
				
				System.out.println("Enter a department: ");
				department = input.nextLine();
				
				System.out.println("Enter expense type: ");
				expenseType = input.nextLine();
				
				Scanner in = new Scanner(System.in);
				System.out.println("Enter receipt total: ");
				num = in.nextDouble();
				
				requestObserver.onNext(AddMultiExpenseClaimRequest.newBuilder()
						.setExpenseClaimNo(expenseClaimNo)
						.setDepartment(department)
						.setExpenseType(expenseType)
						.setAmount(num)
						.build());
				
				addNum = addNum+1;
				
				try {
					Thread.sleep(3000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				
			}while(addNum != 2);
			
			System.out.println("Loading......");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			responseObserver.onCompleted();
			
			
//			finishLatch.await(5, TimeUnit.SECONDS);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
			
			
		}catch (RuntimeException e) {
			e.printStackTrace();
		}

	}
	
	public static void uploadExpenseReceipts() throws IOException {
		StreamObserver<UploadExpenseReceiptsResponse> responseObserver = new StreamObserver<UploadExpenseReceiptsResponse>() {
		
			@Override
			public void onNext(UploadExpenseReceiptsResponse value) {
				System.out.println("File upload status : " + value.getStatus());
			
				
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("ERROR - Client side - file upload");
				
			}

			@Override
			public void onCompleted() {
				System.out.println("File uploaded");
				
			}
			
		};
		
		StreamObserver<UploadExpenseReceiptsRequest> requestObserver = asyncStub.uploadExpenseReceipts(responseObserver);
		String filePath = "C:\\Users\\x20144148\\Desktop\\NCI\\6.Distributed Systems\\CA_Project_CORRECT\\DistSysCAWorkspace\\dsProject\\fileUploadTest\\Recursion.PNG";	
		
		File file = new File(filePath);
		if(!file.exists()) {
			System.out.println("File does not exist");
			return;
		}else {
			try {
				long actualFileSize = file.length();
				int chunkSize = (int) actualFileSize / 4;
				BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(file));
				
				
				int buffSize = chunkSize;
				byte[] byteBuff = new byte[buffSize];
				int size = 0;
				
				try {
					while((size = buffIn.read(byteBuff) ) >0) {
						ByteString bString = ByteString.copyFrom(byteBuff, 0 , (int) actualFileSize);

						requestObserver.onNext(UploadExpenseReceiptsRequest.newBuilder()
								.setData(bString)
								.setFileName(filePath)
								.setSize(size)
								.setActualFileSize(actualFileSize)
								.build());
						
						System.out.println("buff size " + buffSize);
						System.out.println("chunksize " + chunkSize);
						System.out.println("Sending File...");
						
						try {
							Thread.sleep(new Random().nextInt(1000) + 500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						
					}
					
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
					
					
					
					buffIn.close();
					responseObserver.onCompleted();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
//	public static void checkExpenseClaimAsync() {
//		
//		int checkExpenses =1;
//		CheckExpenseClaimRequest req = CheckExpenseClaimRequest.newBuilder()
//				.setCheckAllExpenses(checkExpenses).build();
//		
//		StreamObserver<CheckExpenseClaimResponse> responseObserver = new StreamObserver <CheckExpenseClaimResponse>() {
//
//			@Override
//			public void onNext(CheckExpenseClaimResponse value) {
//				System.out.println("Receiving claimed expenses :");
//				System.out.println("Claim Number : " + value.getClaimNumber() + "Status : " + value.getStatus());
//			}
//
//			@Override
//			public void onError(Throwable t) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onCompleted() {
//				System.out.println("Done");
//				
//			}
//			
//		};
//		
//		asyncStub.checkExpenseClaim(req, responseObserver);
//	}
	
	public static void checkExpenseClaimBlocking() {
		int checkExpenses =1;
		CheckExpenseClaimRequest req = CheckExpenseClaimRequest.newBuilder()
				.setCheckAllExpenses(checkExpenses).build();
		
		try {
			Iterator<CheckExpenseClaimResponse> response = blockingStub.checkExpenseClaim(req);
			while(response.hasNext()) {
				CheckExpenseClaimResponse t = response.next();
				System.out.println("Claim no : " + t.getClaimNumber() + " " +  "Amount : €" + t.getAmount() + " " + "Status : " + t.getStatus());
			}
		}catch(StatusRuntimeException e) {
			e.printStackTrace();
		}
	}
		
}
		
	
	
		



