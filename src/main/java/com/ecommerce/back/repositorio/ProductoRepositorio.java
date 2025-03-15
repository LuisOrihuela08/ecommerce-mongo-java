package com.ecommerce.back.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.back.coleccion.Producto;

public interface ProductoRepositorio extends MongoRepository<Producto, String>{

}
