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

import com.ecommerce.back.coleccion.Rol;
import com.ecommerce.back.dto.RolDTO;
import com.ecommerce.back.service.RolService;

@RestController
@RequestMapping("/api/rol")
public class RolController {

	private static Logger logger = LoggerFactory.getLogger(RolController.class);
	
	@Autowired
	private RolService rolService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllRoles(){
		
		try {
			
			List<Rol> listRoles = rolService.listAllRol();
			
			logger.info("LISTAR ROLES OK");
			return new ResponseEntity<>(listRoles, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("ERROR AL LISTAR ROLES {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al listar los Roles", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createRol(@RequestBody RolDTO rolDTO){
		
		try {
			
			Rol rolNuevo = new Rol();
			rolNuevo.setNombre(rolDTO.getNombre());
			
			rolService.saveRol(rolNuevo);
			
			logger.info("ROL CREADO OK: {}", rolNuevo);
			return new ResponseEntity<>(rolNuevo, HttpStatus.CREATED);
			
		} catch (Exception e) {
			logger.error("ERROR AL GUARDAR EL ROL {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al guardar el Rol", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
