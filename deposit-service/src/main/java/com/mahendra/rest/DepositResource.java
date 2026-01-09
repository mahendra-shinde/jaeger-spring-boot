package com.mahendra.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.models.Deposit;
import com.mahendra.services.DepositService;

import io.opentelemetry.instrumentation.annotations.WithSpan;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/deposits")
public class DepositResource {
	
	@Autowired private DepositService svc;
	
	@GetMapping(value="/{accnum}", produces = "application/json")
	@WithSpan("find-deposit-api")
	public ResponseEntity<Deposit> findByAccNum(@PathVariable("accnum") String accNum){
		Optional<Deposit> dep = svc.findByAccNum(accNum);
		
		if(dep.isPresent()) {
			return ResponseEntity.ok(dep.get());
		}
		return ResponseEntity.notFound().header("Error", "Deposit not found").build();
	}
	
	@PostMapping(consumes = "application/json")
	@WithSpan("create-deposit-api")
	public ResponseEntity<String> save(@RequestBody Deposit deposit) {
		try {
		svc.create(deposit);
		return ResponseEntity.ok("New record created");
		}catch(Exception ex) {
			return ResponseEntity.badRequest().header("Error", ex.getMessage()).body("Cannot create record");
		}
	}
	
	

}
