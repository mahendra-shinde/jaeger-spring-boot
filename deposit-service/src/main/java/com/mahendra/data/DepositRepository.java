package com.mahendra.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.mahendra.models.Deposit;

@Repository
public interface DepositRepository extends ListCrudRepository<Deposit, String> {
	// BASIC CRUD Operations are Auto implemented by Spring DATA-JPA 
}
