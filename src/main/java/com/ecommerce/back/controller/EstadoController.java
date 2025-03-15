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

import com.ecommerce.back.coleccion.Estado;
import com.ecommerce.back.dto.EstadoDTO;
import com.ecommerce.back.service.EstadoService;

@RestController
@RequestMapping(name = "/api/estado")
public class EstadoController {
	
	private static Logger logger = LoggerFactory.getLogger(EstadoController.class);

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/list")
	private ResponseEntity<?> getAllEstado(){
		
		try {
			
			List<Estado> listEstados = estadoService.listEstado();
			logger.info("LISTA DE ESTADOS OK");
			return new ResponseEntity<>(listEstados, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("ERROR AL LISTAR ESTADOS {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al listar los estados", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/create")
	private ResponseEntity<?> createEstado (@RequestBody EstadoDTO estadoDTO){
		
		try {
			
			Estado estadoNuevo = new Estado();
			estadoNuevo.setNombre(estadoDTO.getNombre());
			
			estadoService.saveEstado(estadoNuevo);
			
			logger.info("ESTADO GUARDADO OK");
			logger.info("ESTADO NUEVO: {}", estadoNuevo);
			return new ResponseEntity<>(estadoNuevo, HttpStatus.CREATED);
			
		} catch (Exception e) {
			logger.error("Error al guardar el Estado: {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al guardar el Estado", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
