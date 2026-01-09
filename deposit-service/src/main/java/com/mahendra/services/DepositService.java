package com.mahendra.services;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahendra.data.DepositRepository;
import com.mahendra.models.Deposit;

import jakarta.annotation.PostConstruct;

@Service
public class DepositService {

	@Autowired private DepositRepository dao;
	
	@PostConstruct
	public void init() {
		dao.save(new Deposit("SB1011","Donald Putin",new Date(), 12300D));
		dao.save(new Deposit("SB1012","Vladimir Trump",new Date(), 23200D));
		dao.save(new Deposit("SB1013","Morado Jinpin",new Date(), 3400D));
		dao.save(new Deposit("SB1014","XI Markel",new Date(), 33300D));
	}
	
	
	public void create(Deposit dep) {
		dao.save(dep);
	}
	
	
	public Optional<Deposit> findByAccNum(String accNum) {
		return dao.findById(accNum);
	}
	
	
	public List<Deposit> findAll(){
		return dao.findAll();
	}
}
