package com.ecommerce.back.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.back.coleccion.DetallePedido;
import com.ecommerce.back.coleccion.Pedido;
import com.ecommerce.back.coleccion.Usuario;
import com.ecommerce.back.dto.PedidoDTO;
import com.ecommerce.back.repositorio.DetallePedidoRepositorio;
import com.ecommerce.back.repositorio.PedidoRepositorio;
import com.ecommerce.back.repositorio.UsuarioRepositorio;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private DetallePedidoRepositorio detallePedidoRepositorio;
	
	public List<Pedido> findAllPedidos(){
		return pedidoRepositorio.findAll();
	}
	
	public Pedido savePedido(PedidoDTO pedidoDTO) {
		
		Pedido pedido = new Pedido();
		pedido.setFecha(LocalDate.now());
		pedido.setTotal(pedidoDTO.getTotal());
		
		Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(pedidoDTO.getUsuario_id());
		
		if (usuarioOptional.isEmpty()) {
			throw new RuntimeException("Usuario no encontrado");
		}
		pedido.setUsuario(usuarioOptional.get());
		
		List<DetallePedido> detalles = pedidoDTO.getDetalleIds().stream()
				.map(id -> detallePedidoRepositorio.findById(id)
						.orElseThrow(() -> new RuntimeException("Detalle de pedido no encontrado" + id)))
				.collect(Collectors.toList());


        pedido.setDetallePedido(detalles);

        return pedidoRepositorio.save(pedido);
	}
}
