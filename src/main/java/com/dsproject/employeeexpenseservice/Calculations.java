package com.dsproject.employeeexpenseservice;

public class Calculations {
	
	private double expenseTotal;
	private double num;
	
	public Calculations() {
		
	}
	
	public Calculations (double num) {
		this.num = num;
	}
	
	public double getExpenseTotal() {
		return this.expenseTotal;
	}
	
	public void calRunningTotal(double num) {
		expenseTotal = expenseTotal + num;
		
	}
	

	
	

}
