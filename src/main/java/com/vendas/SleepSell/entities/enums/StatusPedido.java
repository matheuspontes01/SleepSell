package com.vendas.SleepSell.entities.enums;

public enum StatusPedido {
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENTREGUE(3),
	CANCELADO(4),
	ENVIADO(5);
	
	private int code;
	
	private StatusPedido(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusPedido valueOf(int code) {
		for (StatusPedido valor : StatusPedido.values()) {
			if (valor.getCode() == code) {
				return valor;
			}
		}
		
		throw new IllegalArgumentException("Código StatusPedido inválido!");
	}
}
