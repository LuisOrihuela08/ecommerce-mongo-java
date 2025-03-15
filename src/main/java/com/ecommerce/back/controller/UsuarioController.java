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

import com.ecommerce.back.coleccion.Usuario;
import com.ecommerce.back.dto.UsuarioDTO;
import com.ecommerce.back.dto.UsuarioResponseDTO;
import com.ecommerce.back.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	private static Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/list")
	public ResponseEntity<?> listUsuarioRoles(){
		
		try {
			
			List<UsuarioResponseDTO> usuarios = usuarioService.listarUsuariosRoles();
			
			logger.info("LISTAR USUARIOS CON ROLES OK");
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("ERROR AL LISTAR USUARIOS {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al listar los usuarios", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createUsuario(@RequestBody UsuarioDTO usuarioDTO){
		
		try {
			
			Usuario usuarioNuevo = new Usuario();
			usuarioNuevo.setNombre(usuarioDTO.getNombre());
			usuarioNuevo.setPassword(usuarioDTO.getPassword());
			usuarioNuevo.setEmail(usuarioDTO.getEmail());
			usuarioNuevo.setDireccion(usuarioDTO.getDireccion());
			usuarioNuevo.setTelefono(usuarioDTO.getTelefono());
			usuarioNuevo.setAdmin(usuarioDTO.isAdmin());
			
			usuarioService.saveUsuario(usuarioNuevo);
			
			logger.info("USUARIO REGISTRADO OK", usuarioNuevo);
			return new ResponseEntity<>(usuarioNuevo, HttpStatus.CREATED);
			
		} catch (Exception e) {
			logger.error("ERROR AL GUARDAR USUARIO {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al guardar el Usuario", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
