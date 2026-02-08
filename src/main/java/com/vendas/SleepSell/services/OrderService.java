package com.vendas.SleepSell.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.vendas.SleepSell.entities.Mattress;
import com.vendas.SleepSell.entities.Order;
import com.vendas.SleepSell.entities.OrderItem;
import com.vendas.SleepSell.entities.enums.OrderStatus;
import com.vendas.SleepSell.repositories.OrderRepository;
import com.vendas.SleepSell.services.exceptions.DatabaseException;
import com.vendas.SleepSell.services.exceptions.ResourceNotFoundException;
import com.vendas.SleepSell.services.exceptions.StockException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Order insert(Order obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Order update(Integer id, Order obj) {
		try {
			Order entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Order entity, Order obj) {
		entity.setDate(obj.getDate());
		entity.setOrderStatus(obj.getOrderStatus());
		entity.setUser(obj.getUser());
	}
	
	public void confirmOrder(Integer id) {
		Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
		for (OrderItem item : order.getItems()) {
			
			Mattress mattress = item.getMattress();
			int quantity = item.getQuantity();
			
			if (order.getOrderStatus() == OrderStatus.PAID) {
				throw new DatabaseException("Order already confirmed");
			}
			
			if (mattress.getStock() < quantity) {
				throw new StockException("Not enough stock for mattress: " + mattress.getName());
			}
			
			mattress.setStock(mattress.getStock() - quantity);
		}
		
		order.setOrderStatus(OrderStatus.PAID);
	}
	
	public void cancelOrder(Integer id) {
		Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
		if (order.getOrderStatus() != OrderStatus.PAID) return;
		
		for (OrderItem item : order.getItems()) {
			Mattress mattress = item.getMattress();
			mattress.addToStock(item.getQuantity());
		}
		
		order.setOrderStatus(OrderStatus.CANCELED);
	}
}
