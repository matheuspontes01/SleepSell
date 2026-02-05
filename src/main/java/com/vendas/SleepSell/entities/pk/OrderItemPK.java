package com.vendas.SleepSell.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.vendas.SleepSell.entities.Mattress;
import com.vendas.SleepSell.entities.Order;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "mattress_id")
	private Mattress mattress;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Mattress getMattress() {
		return mattress;
	}

	public void setMattress(Mattress mattress) {
		this.mattress = mattress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mattress, order);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(mattress, other.mattress) && Objects.equals(order, other.order);
	}
	
}
