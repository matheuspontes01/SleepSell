package com.vendas.SleepSell.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vendas.SleepSell.entities.Cliente;
import com.vendas.SleepSell.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Cliente u1 = new Cliente(null, "Carlos", "55555555555", "62981818181");
		Cliente u2 = new Cliente(null, "Maria", "44444445555", "62981199080");
		
		clienteRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
}
