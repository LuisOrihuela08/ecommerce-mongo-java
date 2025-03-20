package com.ecommerce.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.back.coleccion.Categoria;
import com.ecommerce.back.coleccion.Producto;
import com.ecommerce.back.dto.ProductoDTO;
import com.ecommerce.back.repositorio.CategoriRepositorio;
import com.ecommerce.back.repositorio.ProductoRepositorio;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	@Autowired
	private CategoriRepositorio categoriRepositorio;
	
	public List<Producto> listAllProductos(){
		return productoRepositorio.findAll();
	}
	
	public Producto saveProducto(ProductoDTO productoDTO) {
		
		Optional<Categoria> categoriaOpt = categoriRepositorio.findById(productoDTO.getCategoria_id());
		if (categoriaOpt.isEmpty()) {
			throw new RuntimeException("Categoria no encontrada");
		}
		
		Producto producto = new Producto();
		producto.setNombre(productoDTO.getNombre());
		producto.setDescripcion(productoDTO.getDescripcion());
		producto.setPrecio(productoDTO.getPrecio());
		producto.setStock(productoDTO.getStock());
		producto.setCategoria(categoriaOpt.get());
		
		return productoRepositorio.save(producto);
	}
	
	public Producto actualizarProducto(Producto producto) {
		return productoRepositorio.save(producto);
	}
	
	public Optional<Producto> getProductoBYId(String producto_id){
		return productoRepositorio.findById(producto_id);
	}
	
	public void deleteProducto(String producto_id) {
		productoRepositorio.deleteById(producto_id);
	}
	
	//Buscar producto por nombre
	public Optional<Producto> getProductoByNombre(String nombre) {
		return productoRepositorio.findByNombre(nombre);
	}
}
