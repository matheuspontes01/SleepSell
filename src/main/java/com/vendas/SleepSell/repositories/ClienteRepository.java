package com.vendas.SleepSell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.SleepSell.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}
