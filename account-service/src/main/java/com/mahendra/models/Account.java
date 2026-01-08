package com.mahendra.models;

import java.time.LocalDate;

public class Account {

	private String accNum;
	private String accHolderName;
	private double balance;
	private LocalDate dateCreated;
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Account(String accNum, String accHolderName, double balance, LocalDate dateCreated) {
		super();
		this.accNum = accNum;
		this.accHolderName = accHolderName;
		this.balance = balance;
		this.dateCreated = dateCreated;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
