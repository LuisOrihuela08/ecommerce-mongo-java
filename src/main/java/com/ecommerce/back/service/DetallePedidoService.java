package com.ecommerce.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.back.coleccion.DetallePedido;
import com.ecommerce.back.coleccion.Producto;
import com.ecommerce.back.dto.DetallePedidoDTO;
import com.ecommerce.back.repositorio.DetallePedidoRepositorio;
import com.ecommerce.back.repositorio.ProductoRepositorio;

@Service
public class DetallePedidoService {

	@Autowired
	private DetallePedidoRepositorio detallePedidoRepositorio;
	
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public List<DetallePedido> listDetallePedidos(){
		return detallePedidoRepositorio.findAll();
	}
	
	public DetallePedido saveDetallePedido(DetallePedidoDTO detallePedidoDTO) {
		
		Optional<Producto> productoOptional = productoRepositorio.findById(detallePedidoDTO.getProducto_id());
		
		if (productoOptional.isEmpty()) {
			throw new RuntimeException("Producto no encontrado");
		}
		
		DetallePedido detalleNuevo = new DetallePedido();
		detalleNuevo.setCantidad(detallePedidoDTO.getCantidad());
		detalleNuevo.setPrecio_unitario(detallePedidoDTO.getPrecio_unitario());
		detalleNuevo.setSubtotal(detallePedidoDTO.getSubtotal());
		detalleNuevo.setProducto(productoOptional.get());
		
		return detallePedidoRepositorio.save(detalleNuevo);
	}
}
