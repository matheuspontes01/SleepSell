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
}
