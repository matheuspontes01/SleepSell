package com.vendas.SleepSell.entities.enums;

public enum PaymentMethod {
	CASH(1),
	CARD(2),
	PAYPAL(3);
	
	private int code;
	
	private PaymentMethod(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static PaymentMethod valueOf(int code) {
		for (PaymentMethod value : PaymentMethod.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid PaymentMethod code!");
	}
}
