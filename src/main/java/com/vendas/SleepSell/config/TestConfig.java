package com.vendas.SleepSell.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vendas.SleepSell.entities.Order;
import com.vendas.SleepSell.entities.User;
import com.vendas.SleepSell.entities.enums.OrderStatus;
import com.vendas.SleepSell.repositories.OrderRepository;
import com.vendas.SleepSell.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Carlos", "55555555555", "62981818181");
		User u2 = new User(null, "Maria", "44444445555", "62981199080");
		
		Order p1 = new Order(null, Instant.parse("2025-09-05T19:07:00Z"), OrderStatus.SHIPPED, u1);
		Order p2 = new Order(null, Instant.parse("2025-10-22T20:11:49Z"), OrderStatus.PAID, u2);
		Order p3 = new Order(null, Instant.parse("2025-06-19T13:45:06Z"), OrderStatus.WAITING_PAYMENT, u2);
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
	
}
