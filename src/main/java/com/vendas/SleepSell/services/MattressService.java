package com.vendas.SleepSell.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.SleepSell.entities.Mattress;
import com.vendas.SleepSell.repositories.MattressRepository;

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
		return obj.get();
	}
	
	public Mattress insert(Mattress obj) {
		return mattressRepository.save(obj);
	}
	
	public void delete(Integer id) {
		mattressRepository.deleteById(id);
	}
	
	public Mattress update(Integer id, Mattress obj) {
		Mattress entity = mattressRepository.getReferenceById(id);
		updateData(entity, obj);
		return mattressRepository.save(entity);
	}

	private void updateData(Mattress entity, Mattress obj) {
		entity.setName(obj.getName());
		entity.setPrice(obj.getPrice());
		entity.setStock(obj.getStock());
		entity.setSupplier(obj.getSupplier());
	}
}
