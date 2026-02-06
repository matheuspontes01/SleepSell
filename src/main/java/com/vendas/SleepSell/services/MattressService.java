package com.vendas.SleepSell.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.vendas.SleepSell.entities.Mattress;
import com.vendas.SleepSell.repositories.MattressRepository;
import com.vendas.SleepSell.services.exceptions.DatabaseException;
import com.vendas.SleepSell.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MattressService {
	@Autowired
	private MattressRepository mattressRepository;
	
	public List<Mattress> findAll() {
		List<Mattress> list = mattressRepository.findAll();
		return list;
	}
	
	public Mattress findById(Integer id) {
		Optional<Mattress> obj = mattressRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Mattress insert(Mattress obj) {
		return mattressRepository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			mattressRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Mattress update(Integer id, Mattress obj) {
		try {
			Mattress entity = mattressRepository.getReferenceById(id);
			updateData(entity, obj);
			return mattressRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Mattress entity, Mattress obj) {
		entity.setName(obj.getName());
		entity.setPrice(obj.getPrice());
		entity.setStock(obj.getStock());
		entity.setSupplier(obj.getSupplier());
	}
}
