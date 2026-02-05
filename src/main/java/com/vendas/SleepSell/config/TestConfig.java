package com.vendas.SleepSell.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vendas.SleepSell.entities.Mattress;
import com.vendas.SleepSell.entities.Order;
import com.vendas.SleepSell.entities.Payment;
import com.vendas.SleepSell.entities.Supplier;
import com.vendas.SleepSell.entities.User;
import com.vendas.SleepSell.entities.enums.OrderStatus;
import com.vendas.SleepSell.entities.enums.PaymentMethod;
import com.vendas.SleepSell.repositories.MattressRepository;
import com.vendas.SleepSell.repositories.OrderRepository;
import com.vendas.SleepSell.repositories.PaymentRepository;
import com.vendas.SleepSell.repositories.SupplierRepository;
import com.vendas.SleepSell.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private MattressRepository mattressRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Carlos", "55555555555", "62981818181");
		User u2 = new User(null, "Maria", "44444445555", "62981199080");
		
		Order p1 = new Order(null, Instant.parse("2025-09-05T19:07:00Z"), OrderStatus.SHIPPED, u1);
		Order p2 = new Order(null, Instant.parse("2025-10-22T20:11:49Z"), OrderStatus.PAID, u2);
		Order p3 = new Order(null, Instant.parse("2025-06-19T13:45:06Z"), OrderStatus.WAITING_PAYMENT, u2);
		
		Payment pa1 = new Payment(null, Instant.parse("2025-09-05T21:07:00Z"), PaymentMethod.CASH, p1);
		Payment pa2 = new Payment(null, Instant.parse("2025-10-22T20:11:49Z"), PaymentMethod.PAYPAL, p2);
		
		Supplier s1 = new Supplier(null, "OrtoBom", "ortobom@gmail.com", "1212123434", "Goiania", "Goias");
		Supplier s2 = new Supplier(null, "Castor", "castor@gmail.com", "4176152434", "Sao Paulo", "Sao Paulo");
		Supplier s3 = new Supplier(null, "Sol", "sol@gmail.com", "6779853444", "Rio de Janeiro", "Rio de Janeiro");
		
		supplierRepository.saveAll(Arrays.asList(s1, s2, s3));
		
		Mattress m1 = new Mattress(null, "Super King", 15, 1350.00, s1);
		Mattress m2 = new Mattress(null, "Queen", 15, 900.00, s1);
		Mattress m3 = new Mattress(null, "King", 15, 1790.00, s2);
		Mattress m4 = new Mattress(null, "Star", 15, 2050.00, s3);
		Mattress m5 = new Mattress(null, "Super Star", 15, 1700.00, s3);
		
		mattressRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5));
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(p1, p2, p3));
		paymentRepository.saveAll(Arrays.asList(pa1, pa2));
	}
	
}
