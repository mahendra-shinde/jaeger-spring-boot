package com.mahendra.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.services.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountResource {

	@Autowired private AccountService service;
	
	/// http://localhost:9000/api/accounts/SB1010/5000 SUCCESS
	/// http://localhost:9000/api/accounts/SB1015/2000 FAIL
	@GetMapping(value="/{accNo}/{amount}")
	public String deposit(@PathVariable("accNo") String accNo, @PathVariable("amount") double amount) {
		if(service.deposit(accNo, amount)) {
			return "Rs "+amount+" deposited into Acc "+accNo;
		}else
			return "Transaction failed";		 
	}
}
