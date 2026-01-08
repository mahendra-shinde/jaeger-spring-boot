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

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;

@RestController
@RequestMapping("/api/loans")
public class LoanResource {
	
	@Autowired private Tracer tracer;
	
	@Autowired 
	private RestTemplate client;
	
	@Value("${customerservice.endpoint}")
	private String customerEndpoint;

	@GetMapping(value="{ACCNO}", produces = "application/json")
	public Loan findLoan(@PathVariable("ACCNO") String accNo) {
		delayProcessing(2);
		//Customer cust = client.getForObject(customerEndpoint +"/api/customer/1", Customer.class);
		Customer cust = null;
		Span span1 = tracer.spanBuilder("find-customer").setAttribute("loan-acc", accNo).startSpan();
		
		try(Scope scope = span1.makeCurrent()){
			ResponseEntity<Customer> resp = client.getForEntity(customerEndpoint +"/api/customer/1", Customer.class);
			
			if(resp.getStatusCode() == HttpStatus.OK) {
				delayProcessing(2);
				cust = resp.getBody();
			}				
		}catch(Exception e) {
			span1.recordException(e);
			span1.setStatus(StatusCode.ERROR, "Failed to find customer!");
			throw e;
		}finally {
			span1.end();
		}
		delayProcessing(1);
		
		Span span2 = tracer.spanBuilder("find-loan").setAttribute("loan-acc", accNo).startSpan();
		
		try(Scope scope = span2.makeCurrent()){
			Loan loan = new Loan(accNo, 8030000.00, 9.55, LocalDate.of(2021,2, 12), 36540.00, cust);
			return loan;
		}catch(Exception e) {
			
		}finally {
			span2.end();
		}
		
		return null;
	}
	
	private void delayProcessing(int seconds) {
		try {
		Thread.sleep(seconds*1000);
		}catch(InterruptedException ex) {
			System.out.println("Exception while delayed");
		}
		
	}
}
