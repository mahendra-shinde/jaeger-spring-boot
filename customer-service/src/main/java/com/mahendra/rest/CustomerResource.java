package com.mahendra.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.models.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerResource {

	@GetMapping(value="/{ID}", produces="application/json")
	public ResponseEntity<Customer> findCustomer(@PathVariable("ID") int id )
	{
		delayProcessing(2);
		if(id >=1 && id <=5) {
			delayProcessing(5);
			Customer cust = new Customer("C"+id,"User "+id , "Rao", "user-"+id+"@xyz.com");
			return ResponseEntity.ok(cust);
		}else
			return ResponseEntity.status(404).build();
	}
	
	
	private void delayProcessing(int seconds) {
		try {
		Thread.sleep(seconds*1000);
		}catch(InterruptedException ex) {
			System.out.println("Exception while delayed");
		}
		
	}
}
