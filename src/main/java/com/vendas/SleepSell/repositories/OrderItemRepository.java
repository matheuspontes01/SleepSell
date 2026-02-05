package com.vendas.SleepSell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendas.SleepSell.entities.OrderItem;
import com.vendas.SleepSell.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
