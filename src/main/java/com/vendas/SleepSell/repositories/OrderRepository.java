package com.vendas.SleepSell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.SleepSell.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
