package com.mahendra.models;

import java.time.LocalDate;

public class Loan {

	private String accNum;
	private double amountDisbursed;
	private double rateOfInterest;
	private LocalDate disbursementDate;
	private double emi;
	private Customer customer;

	
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(String accNum, double amountDisbursed, double rateOfInterest, LocalDate disbursementDate, double emi,
			Customer customer) {
		super();
		this.accNum = accNum;
		this.amountDisbursed = amountDisbursed;
		this.rateOfInterest = rateOfInterest;
		this.disbursementDate = disbursementDate;
		this.emi = emi;
		this.customer = customer;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public double getAmountDisbursed() {
		return amountDisbursed;
	}

	public void setAmountDisbursed(double amountDisbursed) {
		this.amountDisbursed = amountDisbursed;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public LocalDate getDisbursementDate() {
		return disbursementDate;
	}

	public void setDisbursementDate(LocalDate disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
	
}
