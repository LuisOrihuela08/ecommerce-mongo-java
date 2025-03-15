package com.ecommerce.back.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.back.coleccion.Pedido;
import com.ecommerce.back.dto.PedidoDTO;
import com.ecommerce.back.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	private static Logger logger = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/list")
	public ResponseEntity<?> listAllPedidos(){
		
		try {
			
			List<Pedido> listPedidos = pedidoService.findAllPedidos();
			logger.info("LISTAR PEDIDOS OK");
			return new ResponseEntity<>(listPedidos, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("ERROR AL LISTAR PEDIDOS");
			return new ResponseEntity<>(Map.of("error", "Error al listar los pedidos", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createPedido(@RequestBody PedidoDTO pedidoDTO){
		
		try {
			
			Pedido pedidoNuevo = pedidoService.savePedido(pedidoDTO);
			
			logger.info("GUARDAR PEDIDO OK {}", pedidoNuevo);
			return new ResponseEntity<>(pedidoNuevo, HttpStatus.CREATED);
			
		} catch (Exception e) {
			logger.error("ERROR AL GUARDAR PEDIDO {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al guardar el pedido", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
