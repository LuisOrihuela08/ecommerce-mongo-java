package com.ecommerce.back.repositorio;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.back.coleccion.Producto;

public interface ProductoRepositorio extends MongoRepository<Producto, String>{

	Optional<Producto> findByNombre(String nombre); 
}
