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

import com.ecommerce.back.coleccion.Producto;
import com.ecommerce.back.dto.ProductoDTO;
import com.ecommerce.back.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	private static Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/list")
	public ResponseEntity<?> listAllProducts(){
		
		try {
			
			List<Producto> listProductos = productoService.listAllProductos();
			
			logger.info("LISTAR PRODUCTOS OK");
			return new ResponseEntity<>(listProductos, HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("ERROR AL LISTAR PRODUCTOS", e);
			return new ResponseEntity<>(Map.of("error", "Hubo un error al listar los productos", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@RequestBody ProductoDTO productoDTO){
		
		try {
			
			Producto productoNuevo = productoService.saveProducto(productoDTO);
				
			logger.info("PRODUCTO GUARDADO OK");
			logger.info("PRODUCTO NUEVO: {}", productoNuevo);
			return new ResponseEntity<>(productoNuevo, HttpStatus.CREATED);
			
		} catch (Exception e) {
			logger.error("ERROR AL GUARDAR EL PRODUCTO");
			return new ResponseEntity<>(Map.of("error", "Error al guardar el producto", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
