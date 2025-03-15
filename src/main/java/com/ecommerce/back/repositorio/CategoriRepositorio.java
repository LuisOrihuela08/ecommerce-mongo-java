package com.ecommerce.back.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.back.coleccion.Categoria;

public interface CategoriRepositorio extends MongoRepository<Categoria, String>{

}
