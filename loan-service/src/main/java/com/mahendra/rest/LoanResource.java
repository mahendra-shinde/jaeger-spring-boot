package com.mahendra.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mahendra.models.*;

@RestController
@RequestMapping("/api/loans")
public class LoanResource {
	
	@Autowired 
	private RestTemplate client;
	
	@Value("${customerservice.endpoint}")
	private String customerEndpoint;

	@GetMapping(value="{ACCNO}", produces = "application/json")
	public Loan findLoan(@PathVariable("ACCNO") String accNo) {
		delayProcessing(2);
		//Customer cust = client.getForObject(customerEndpoint +"/api/customer/1", Customer.class);
		ResponseEntity<Customer> resp = client.getForEntity(customerEndpoint +"/api/customer/1", Customer.class);
		Customer cust = null;
		if(resp.getStatusCode() == HttpStatus.OK) {
			delayProcessing(2);
			cust = resp.getBody();
		}
		delayProcessing(1);
		Loan loan = new Loan(accNo, 8030000.00, 9.55, LocalDate.of(2021,2, 12), 36540.00, cust);
		return loan;
	}
	
	private void delayProcessing(int seconds) {
		try {
		Thread.sleep(seconds*1000);
		}catch(InterruptedException ex) {
			System.out.println("Exception while delayed");
		}
		
	}
}
