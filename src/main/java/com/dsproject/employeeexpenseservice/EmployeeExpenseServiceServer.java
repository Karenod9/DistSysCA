package com.dsproject.employeeexpenseservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.dsproject.employeeexpenseservice.EmployeeExpenseServiceGrpc.EmployeeExpenseServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.BufferedOutputStream;
import java.io.File;


	
public class EmployeeExpenseServiceServer extends EmployeeExpenseServiceImplBase {
	
	private static final Logger logger = Logger.getLogger(EmployeeExpenseServiceServer.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {

		EmployeeExpenseServiceServer employeeExpenseServiceServer = new EmployeeExpenseServiceServer();
		
		Properties prop = employeeExpenseServiceServer.getProperties();
		employeeExpenseServiceServer.registerService(prop);
		
		int port = Integer.valueOf(prop.getProperty("service_port"));
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(employeeExpenseServiceServer)
					.build()
					.start();
			logger.info("Server started, listening on " + port);
			server.awaitTermination();
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	private Properties getProperties() {
		Properties prop = null;
		try(InputStream input = new FileInputStream("src/main/resources/employeeExpenseService.properties")){
			prop = new Properties();
			prop.load(input);
			System.out.println("Employee Expense Service properties : ");
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " +prop.getProperty("service_port"));
	        
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return prop;
			
	}
	private void registerService(Properties prop) {
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			String service_type = prop.getProperty("service_type");
			String service_name = prop.getProperty("service_name");
			int service_port = Integer.valueOf(prop.getProperty("service_port"));
			
			String service_description_properties = prop.getProperty("service_description");
			
			ServiceInfo empServiceInfo = ServiceInfo.create(service_type,  service_name,  service_port,  service_description_properties);
			jmdns.registerService(empServiceInfo);
			
			System.out.printf("registering service with type %s and name %s \n", service_type, service_name);
			
			Thread.sleep(1000);
			//jmdns.unregisterAllServices();
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch(InterruptedException e) {
			e.printStackTrace();
			
			
		}
	}
	
	
	@Override
	public void addExpenseClaim(AddExpenseClaimRequest request, StreamObserver<AddExpenseClaimResponse> responseObserver) {
		String department = request.getDepartment();
		String expenseType = request.getExpenseType();
		double totalAmt = request.getTotalAmt();
		int expenseClaimNo = request.getExpenseClaimNo();
		
		if(totalAmt < 0.01) {
			responseObserver.onNext(AddExpenseClaimResponse.newBuilder()
					.setClaimResult("Expense Claim No: " + expenseClaimNo + "\nDepartment : " + department + "\nExpense Type : " + expenseType + "\nAmount : " + totalAmt +
							"\nError - Claim cannot be less than 0.00. Please enter a valid amount")
					.build());
		}
		
		else if (totalAmt >= 0.01 && totalAmt <= 50.00) {
			responseObserver.onNext(AddExpenseClaimResponse.newBuilder()
					.setClaimResult("Expense Claim No: " + expenseClaimNo + "\nDepartment : " + department + "\nExpense Type : " + expenseType + "\nAmount : " + totalAmt +
							"\nYour claim has been approved and has been sent to payroll for processing with your next pay date")
					.build());
			
		}else if (totalAmt > 50.00) {
			responseObserver.onNext(AddExpenseClaimResponse.newBuilder()
					.setClaimResult("Expense Claim No: " + expenseClaimNo + "\nDepartment : " + department + "\nExpense Type : " + expenseType + "\nAmount : " + totalAmt +
							"\nYour claim has been sent for processing. Please contact your manager should you have any issues. "
							+ "\nPlease allow 2-3 days for a response.")
					.build());
		}
		responseObserver.onCompleted();
	}
	
		
	public StreamObserver<AddMultiExpenseClaimRequest> addMultiExpenseClaim (StreamObserver<AddMultiExpenseClaimResponse> responseObserver){
		return new StreamObserver<AddMultiExpenseClaimRequest>() {
		//StreamObserver<AddMultiExpenseClaimRequest> requestObserver = new StreamObserver<AddMultiExpenseClaimRequest>() {
			Double currentAmount = 0.00;
			double runningTotal = 0.00;
			DecimalFormat df = new DecimalFormat("###.##");
			
			String department;
			String expenseType;
			int expenseClaimNo;
			
			
			@Override
			public void onNext(AddMultiExpenseClaimRequest req) {
				Double currentAmount = req.getAmount();
				//String claimResult;
				runningTotal = currentAmount + runningTotal;
				
				department = req.getDepartment();
				expenseType = req.getExpenseType();
				expenseClaimNo = req.getExpenseClaimNo();
				
				if(currentAmount < 0.01) {
					AddMultiExpenseClaimResponse response = AddMultiExpenseClaimResponse.newBuilder()
							.setClaimResult("Expense Claim No: " + expenseClaimNo + "\nDepartment : " + department + "\nExpense Type : " + expenseType + "\nAmount : " + currentAmount +
									"\nError - Claim cannot be less than 0.00. Please enter a valid amount")
							.setRunningTotal(runningTotal)
							.build();
					
					responseObserver.onNext(response);
				
				}
				
				else if (currentAmount >= 0.01 && currentAmount <= 50.00) {
					AddMultiExpenseClaimResponse response = AddMultiExpenseClaimResponse.newBuilder()
							.setClaimResult("Expense Claim No: " + expenseClaimNo + "\nDepartment : " + department + "\nExpense Type : " + expenseType + "\nAmount : " + currentAmount +
									"\nYour claim has been approved and has been sent to payroll for processing with your next pay date")
							.setRunningTotal(runningTotal)
							.build();
					
					responseObserver.onNext(response);
					
					
				}else if (currentAmount > 50.00) {
					AddMultiExpenseClaimResponse response = AddMultiExpenseClaimResponse.newBuilder()
							.setClaimResult("Expense Claim No: " + expenseClaimNo + "\nDepartment : " + department + "\nExpense Type : " + expenseType + "\nAmount : " + currentAmount +
									"\nYour claim has been sent for processing. Please contact your manager should you have any issues. "
									+ "\nPlease allow 2-3 days for a response.")
							.setRunningTotal(runningTotal)
							.build();
					
					responseObserver.onNext(response);
					
				}
				
				System.out.println("Receiving expense requests : " +"\nExpense Claim No = " + req.getExpenseClaimNo() 
				+ "\nDepartment  = " + req.getDepartment() +"\nExpense Type = " + req.getExpenseType() +"\nReceipt amount = " + req.getAmount());
				System.out.println("-------------------------------------------------");
				
				//responseObserver.onCompleted();
				
				
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("ERROR - Server=side - multi-expense");
				//responseObserver.onCompleted();
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("Total Amount received : " + df.format(runningTotal));
				
				responseObserver.onCompleted();
				
			}
			
//			@Override
//			public void onHalfClose() {
//				
//			}
			
		};
	}
	
	
	
	@Override
	public StreamObserver<UploadExpenseReceiptsRequest> uploadExpenseReceipts(StreamObserver<UploadExpenseReceiptsResponse> responseObserver){
		return new StreamObserver<UploadExpenseReceiptsRequest>() {
		
		//StreamObserver <UploadExpenseReceiptsRequest> requestObserver = new StreamObserver<UploadExpenseReceiptsRequest>() {
			
			byte[] data;
			long actualSize = 0;
			long currentSize = 0;
			long totalRec = 0;
			String fileName;
			Status status = Status.PENDING;
			
			@Override
			//client sends a message
			public void onNext(UploadExpenseReceiptsRequest req) {
				actualSize = req.getActualFileSize();
				
			while(totalRec < actualSize) {
				
					data = req.getData().toByteArray();
					currentSize = req.getSize();
					totalRec = currentSize + totalRec;
				
					fileName = req.getFileName();
					status = Status.IN_PROGRESS;
					
					System.out.println("Receiving....");
					System.out.println("File size " + actualSize);
					System.out.println("tot rec" + totalRec);
					
					
				}
			
			//System.out.println("Finished upload....");
				
			}
							
			@Override
			//client sends an error
			public void onError(Throwable t) {
				status = Status.FAILED;
				System.out.println("ERROR - Server=side - upload file");
				t.printStackTrace();
				
			}

			@Override
			//client is finished
			public void onCompleted() {
				status = Status.UPLOADED;
				UploadExpenseReceiptsResponse response = UploadExpenseReceiptsResponse.newBuilder()
						.setStatus(status)
						.setFileName(fileName)
						.setSize(actualSize)
						.build();
			
				System.out.println("Complete Server side ");
				responseObserver.onNext(response);
				responseObserver.onCompleted();
				
//				
//				System.out.println("File name: " + fileName + "size : " + size + " STATUS : " );
//				System.out.print(status);
//				System.out.println("File uploaded");
				
			
			
			}
			
		};
		
}


	
	@Override
	public void checkExpenseClaim(CheckExpenseClaimRequest request, StreamObserver<CheckExpenseClaimResponse> responseObserver){
			
			System.out.println("Checking claim requests...");
			int checkAllExpenses = request.getCheckAllExpenses();
			if(checkAllExpenses == 1) {
			
				Random ran = new Random();
			
				int randomAmount = ran.nextInt((50 - 1) +1) + 1;
			
				for(int i=0; i < randomAmount; i++) {
					int ranClaimNumber = ran.nextInt((100000 - 10) + 1)+ 10;
					String claimNumber = String.valueOf(ranClaimNumber);
					double ranReceiptAmount = ran.nextInt(1000) / 10.00;
					ClaimStatus status = ClaimStatus.APPROVED;
					
					if(ranReceiptAmount > 0.01 && ranReceiptAmount <= 20.00) {
						status = ClaimStatus.PAID;
					}else if(ranReceiptAmount > 20.01 && ranReceiptAmount <= 50.00) {
						status = ClaimStatus.APPROVED;
					}else if(ranReceiptAmount > 50.00) {
						status = ClaimStatus.SENT_FOR_APPROVAL;
					}else if(ranReceiptAmount > 90.00) {
						status = ClaimStatus.DENIED;
					}		
					
					
					responseObserver.onNext(CheckExpenseClaimResponse.newBuilder()
							.setClaimNumber(claimNumber)
							.setAmount(ranReceiptAmount)
							.setStatus(status)
							.build());
					
					
//					CheckExpenseClaimResponse res = CheckExpenseClaimResponse.newBuilder().setClaimNumber(claimNumber).setStatus(status).build();
//					responseObserver.onNext(res);
				}
					
			}else{
				System.out.println("not 1");
			}
			System.out.println("All claims sent!");
			responseObserver.onCompleted();
		}
	}


	
	
	
	
		



