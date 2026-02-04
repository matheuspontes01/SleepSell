package com.vendas.SleepSell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.SleepSell.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
