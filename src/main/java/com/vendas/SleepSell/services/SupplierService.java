package com.vendas.SleepSell.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.SleepSell.entities.Supplier;
import com.vendas.SleepSell.repositories.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	
	public List<Supplier> findAll() {
		List<Supplier> list = supplierRepository.findAll();
		return list;
	}
	
	public Supplier findById(Integer id) {
		Optional<Supplier> obj = supplierRepository.findById(id);
		return obj.get();
	}
}
