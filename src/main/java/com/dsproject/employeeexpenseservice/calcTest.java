package com.dsproject.employeeexpenseservice;

import java.util.Scanner;

public class calcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double num;
		double runningTotal;
		int addNum = 1;
		
		Scanner in = new Scanner(System.in);
		Calculations cal = new Calculations();
		
		do {
		
			System.out.println("Add a number: ");
			num = in.nextDouble();
			cal.calRunningTotal(num);
			runningTotal = cal.getExpenseTotal();
		
		
			System.out.println("Running total is : " + runningTotal);
			
			System.out.println("Type 1  to add another expense or 0 to quit");
			addNum = in.nextInt();
		}while(addNum == 1);
		
	}

}



//requestObserver.onNext(AddMultiExpenseClaimRequest.newBuilder().setTotalAmt(20.00).build());
//requestObserver.onNext(AddMultiExpenseClaimRequest.newBuilder().setTotalAmt(10.00).build());
//requestObserver.onNext(AddMultiExpenseClaimRequest.newBuilder().setTotalAmt(100.00).build());
//requestObserver.onNext(AddMultiExpenseClaimRequest.newBuilder().setTotalAmt(20.00).build());