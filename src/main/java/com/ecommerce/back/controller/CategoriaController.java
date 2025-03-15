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

import com.ecommerce.back.coleccion.Categoria;
import com.ecommerce.back.dto.CategoriaDTO;
import com.ecommerce.back.service.CategoriaService;

@RestController
@RequestMapping("/api/categoia")
public class CategoriaController {

	private static Logger logger = LoggerFactory.getLogger(CategoriaController.class);
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllCategorias(){
		
		try {
			
			List<Categoria> listCategorias = categoriaService.listCategoria();
			
			logger.info("LISTAR CATEGORIAS OK");
			return new ResponseEntity<>(listCategorias, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("ERROR AL LISTAR CATEGORIA {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al obtener la lista de Categorias", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createCategoria(@RequestBody CategoriaDTO categoriaDTO){
		
		try {
			
			Categoria categoriaNueva = new Categoria();
			categoriaNueva.setNombre(categoriaDTO.getNombre());
			
			categoriaService.saveCategoria(categoriaNueva);
			
			logger.info("CATEGORIA GUARDADO OK");
			logger.info("Categoria Nueva: {}", categoriaNueva);
			return new ResponseEntity<>(categoriaService, HttpStatus.CREATED);
			
		} catch (Exception e) {
			logger.error("ERROR AL GUARDAR CATEGORIA", e);
			return new ResponseEntity<>(Map.of("error", "Error al guardar la categoria", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
