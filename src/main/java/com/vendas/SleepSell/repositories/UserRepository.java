package com.vendas.SleepSell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.SleepSell.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
