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

import com.ecommerce.back.coleccion.DetallePedido;
import com.ecommerce.back.dto.DetallePedidoDTO;
import com.ecommerce.back.service.DetallePedidoService;

@RestController
@RequestMapping("/api/detalles")
public class DetallePedidoController {
	
	private static Logger logger = LoggerFactory.getLogger(DetallePedidoController.class);

	@Autowired
	private DetallePedidoService detallePedidoService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getDetallePedidos(){
		
		try {
			
			List<DetallePedido> listDetalles = detallePedidoService.listDetallePedidos();
			logger.info("LISTAR DETALLES OK");
			return new ResponseEntity<>(listDetalles, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("ERROR AL LISTAR DETALLES {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al listar los detalles de los Productos", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createDetallePedido(@RequestBody DetallePedidoDTO detallePedidoDTO){
		
		try {
			
			DetallePedido detalleNuevo = detallePedidoService.saveDetallePedido(detallePedidoDTO);
			
			logger.info("DETALLE CREADO OK");
			return new ResponseEntity<>(detalleNuevo, HttpStatus.CREATED);
					
		} catch (Exception e) {
			logger.error("ERROR AL CREAR DETALLE {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al guardar el detalle de pedido", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
