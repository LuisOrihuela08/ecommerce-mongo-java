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

import com.ecommerce.back.coleccion.Pago;
import com.ecommerce.back.dto.PagoDTO;
import com.ecommerce.back.service.PagoService;

@RestController
@RequestMapping("/api/pago")
public class PagoController {

	private static Logger logger = LoggerFactory.getLogger(PagoController.class);
	
	@Autowired
	private PagoService pagoService;
	
	@GetMapping("/list")
	public ResponseEntity<?> listAllPagos(){
		
		try {
			
			List<Pago> listPagos = pagoService.listPago();
			
			logger.info("LISTAR PAGOS OK");
			return new ResponseEntity<>(listPagos, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("ERROR AL LISTAR PAGOS {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al listar los pagos", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createPago(@RequestBody PagoDTO pagoDTO){
		
		try {
			
			Pago pagoNuevo = pagoService.savePago(pagoDTO);
			
			logger.info("CREAR PAGO OK");
			return new ResponseEntity<>(pagoNuevo, HttpStatus.CREATED);
			
		} catch (Exception e) {
			logger.error("ERROR AL GUARDAR PAGO {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al guardar el Pago", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
