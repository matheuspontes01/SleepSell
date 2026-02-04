package com.vendas.SleepSell.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.SleepSell.entities.Payment;
import com.vendas.SleepSell.repositories.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public List<Payment> findAll() {
		List<Payment> list = paymentRepository.findAll();
		return list;
	}
	
	public Payment findById(Integer id) {
		Optional<Payment> obj = paymentRepository.findById(id);
		return obj.get();
	}
}
