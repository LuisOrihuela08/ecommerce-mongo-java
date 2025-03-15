package com.ecommerce.back.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.back.coleccion.Estado;

public interface EstadoRepositorio extends MongoRepository<Estado, String>{

}
