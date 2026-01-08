package com.mahendra.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.exceptions.NonExistingAccountException;
import com.mahendra.services.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountResource {

	@Autowired private AccountService service;
	
	/// http://localhost:9000/api/accounts/SB1010/5000 SUCCESS
	/// http://localhost:9000/api/accounts/SB1015/2000 FAIL
	@GetMapping(value="/{accNo}/{amount}")
	public ResponseEntity<String> deposit(@PathVariable("accNo") String accNo, @PathVariable("amount") double amount) {
		try {			
		service.deposit(accNo, amount);
		String msg = "Rs "+amount+" deposited into Acc "+accNo;
		return ResponseEntity.ok(msg);
		
		}catch(NonExistingAccountException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot perform deposit "+ex.getMessage());	
			
		}		 
	}
}
