package com.ecommerce.back.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.back.coleccion.Usuario;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{

}
