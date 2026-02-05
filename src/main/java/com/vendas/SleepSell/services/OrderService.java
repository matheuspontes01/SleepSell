package com.vendas.SleepSell.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendas.SleepSell.entities.Order;
import com.vendas.SleepSell.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
	public Order insert(Order obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Order update(Integer id, Order obj) {
		Order entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Order entity, Order obj) {
		entity.setDate(obj.getDate());
		entity.setOrderStatus(obj.getOrderStatus());
		entity.setUser(obj.getUser());
	}
}
