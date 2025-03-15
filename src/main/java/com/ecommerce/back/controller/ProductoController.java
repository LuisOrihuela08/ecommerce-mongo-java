package com.ecommerce.back.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.back.coleccion.Categoria;
import com.ecommerce.back.coleccion.Producto;
import com.ecommerce.back.dto.ProductoDTO;
import com.ecommerce.back.repositorio.CategoriRepositorio;
import com.ecommerce.back.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	private static Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriRepositorio categoriRepositorio;
	
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
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProducto(@PathVariable ("id") String producto_id,
										    @RequestBody ProductoDTO productoDTO){
		
		try {
			
			Optional<Producto> productoOptional = productoService.getProductoBYId(producto_id);
			
			if (productoOptional.isEmpty()) {
				throw new RuntimeException("Producto no encontrado");
			}
			
			Producto productoExistente = productoOptional.get();
			productoExistente.setNombre(productoDTO.getNombre());
			productoExistente.setDescripcion(productoDTO.getDescripcion());
			productoExistente.setPrecio(productoDTO.getPrecio());
			productoExistente.setStock(productoDTO.getStock());
			
			Optional<Categoria> categoriaOptional = categoriRepositorio.findById(productoDTO.getCategoria_id());
			
			if (categoriaOptional.isEmpty()) {
				throw new RuntimeException("Categoria no encontrada");
			}
			productoExistente.setCategoria(categoriaOptional.get());
			
			Producto productoActualizado = productoService.actualizarProducto(productoExistente);
			
			logger.info("PRODUCTO ACTUALIZADO OK {}", productoActualizado);
			return new ResponseEntity<>(productoActualizado, HttpStatus.OK);		
			
		} catch (Exception e) {
			logger.error("ERROR AL ACTUALIZAR EL PRODUCTO {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al actualizar el Producto", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProducto(@PathVariable ("id") String producto_id){
		
		try {
			
			Optional<Producto> productoOptional = productoService.getProductoBYId(producto_id);
			if (productoOptional.isEmpty()) {
				throw new RuntimeException("Producto no encontrado");
			}
			productoService.deleteProducto(producto_id);
			
			logger.info("PRODUCTO ELIMINADO OK");
			return new ResponseEntity<>(Map.of("mensaje: ", "Producto eliminado con éxito"), HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("ERROR AL ELIMINAR PRODUCTO {}", e);
			return new ResponseEntity<>(Map.of("error", "Error al eliminar el Producto", "detalle", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
