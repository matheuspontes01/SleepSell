package com.vendas.SleepSell.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vendas.SleepSell.entities.Cliente;
import com.vendas.SleepSell.entities.Pedido;
import com.vendas.SleepSell.entities.enums.StatusPedido;
import com.vendas.SleepSell.repositories.ClienteRepository;
import com.vendas.SleepSell.repositories.PedidoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Cliente u1 = new Cliente(null, "Carlos", "55555555555", "62981818181");
		Cliente u2 = new Cliente(null, "Maria", "44444445555", "62981199080");
		
		Pedido p1 = new Pedido(null, Instant.parse("2025-09-05T19:07:00Z"), StatusPedido.ENVIADO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2025-10-22T20:11:49Z"), StatusPedido.PAGO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2025-06-19T13:45:06Z"), StatusPedido.AGUARDANDO_PAGAMENTO, u2);
		
		
		clienteRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
	
}
