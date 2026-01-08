package com.mahendra.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.Address;

@RestController
@RequestMapping("/api/address")
public class AddressResource {

	@GetMapping(value="/{ID}", produces = "application/json")
	public Address findAddress(@PathVariable("ID") String id) {
		Address address = new Address("Sector 93","Noida", "Delhi NCR", "Uttar Pradesh");
		return address;
	}
}
