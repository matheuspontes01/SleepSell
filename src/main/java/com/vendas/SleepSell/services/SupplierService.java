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
	
	public Supplier insert(Supplier obj) {
		return supplierRepository.save(obj);
	}
	
	public void delete(Integer id) {
		supplierRepository.deleteById(id);
	}
	
	public Supplier update(Integer id, Supplier obj) {
		Supplier entity = supplierRepository.getReferenceById(id);
		updateData(entity, obj);
		return supplierRepository.save(entity);
	}

	private void updateData(Supplier entity, Supplier obj) {
		entity.setCity(obj.getCity());
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPhone(obj.getPhone());
		entity.setUf(obj.getUf());
	}
}
