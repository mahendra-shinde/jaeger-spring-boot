package com.mahendra.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="deposits")
public class Deposit {
	
	@Id @Column(name="acc_no",length = 10) 
	private String accNum;
	
	@Column(name="acc_holder", length = 250)
	private String accHolder;
	
	@Column(name="issue_date")
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	
	@Column(name="amount_invested")
	private Double amount;

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Deposit(String accNum, String accHolder, Date issueDate, Double amount) {
		super();
		this.accNum = accNum;
		this.accHolder = accHolder;
		this.issueDate = issueDate;
		this.amount = amount;
	}

	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
