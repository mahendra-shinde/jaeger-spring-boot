package com.mahendra.services;

import org.springframework.stereotype.Service;

import com.mahendra.exceptions.NonExistingAccountException;
import com.mahendra.models.Account;

import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.annotation.PostConstruct;

import java.time.LocalDate;
import java.util.*;

@Service
public class AccountService {

	HashMap<String, Account> accounts = new HashMap<>();
	
	@PostConstruct
	public void init() {
		accounts.put("SB1010", new Account("SB1010", "Rajiv Bhatia", 12300.30, LocalDate.of(2018, 1,4)));
		accounts.put("SB1011", new Account("SB1011", "Vishal Devgan", 22300.50, LocalDate.of(2017, 5,10)));
		accounts.put("SB1012", new Account("SB1012", "Tammana Bhatia", 67300.30, LocalDate.of(2020, 2,14)));		
	}
	
	@WithSpan("find-account")
	public Account findAccount(@SpanAttribute("acc-no") String accNo) {
		Account acc = accounts.get(accNo);
		return acc;
	}
	
	
	@WithSpan("deposit")
	public void deposit(@SpanAttribute("acc-no") String accNo, @SpanAttribute("amount")double amount) {
		Account acc = findAccount(accNo);
		if(acc == null ) {
			throw new NonExistingAccountException(accNo);			
		}
		acc.setBalance(acc.getBalance()+amount);
	}
	
}
