package com.vendas.SleepSell.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.vendas.SleepSell.entities.Supplier;
import com.vendas.SleepSell.repositories.SupplierRepository;
import com.vendas.SleepSell.services.exceptions.DatabaseException;
import com.vendas.SleepSell.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Supplier insert(Supplier obj) {
		return supplierRepository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			supplierRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Supplier update(Integer id, Supplier obj) {
		try {
			Supplier entity = supplierRepository.getReferenceById(id);
			updateData(entity, obj);
			return supplierRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Supplier entity, Supplier obj) {
		entity.setCity(obj.getCity());
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPhone(obj.getPhone());
		entity.setUf(obj.getUf());
	}
}
