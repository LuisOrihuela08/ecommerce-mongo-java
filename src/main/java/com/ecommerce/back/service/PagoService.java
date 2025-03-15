package com.ecommerce.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.back.coleccion.Estado;
import com.ecommerce.back.coleccion.Pago;
import com.ecommerce.back.coleccion.Pedido;
import com.ecommerce.back.dto.PagoDTO;
import com.ecommerce.back.repositorio.EstadoRepositorio;
import com.ecommerce.back.repositorio.PagoRepositorio;
import com.ecommerce.back.repositorio.PedidoRepositorio;

@Service
public class PagoService {

	@Autowired
	private PagoRepositorio pagoRepositorio;
	
	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	public List<Pago> listPago(){
		return pagoRepositorio.findAll();
	}
	
	public Pago savePago(PagoDTO pagoDTO) {
		
		Pago pagoNuevo = new Pago();
		pagoNuevo.setMetodo_pago(pagoDTO.getMetodo_pago());
		pagoNuevo.setMonto(pagoDTO.getMonto());
		
		Optional<Estado> estadoOptional = estadoRepositorio.findById(pagoDTO.getEstado_id());
		
		if (estadoOptional.isEmpty()) {
			throw new RuntimeException("Estado no encontrado");
		}
		pagoNuevo.setEstado(estadoOptional.get());
		
		Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(pagoDTO.getPedido_id());
		
		if (pedidoOptional.isEmpty()) {
			throw new RuntimeException("Pedido no encontrado");
		}
		pagoNuevo.setPedido(pedidoOptional.get());
		
		return pagoRepositorio.save(pagoNuevo);
		
	}
}
