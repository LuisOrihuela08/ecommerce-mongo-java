package com.ecommerce.back.repositorio;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.back.coleccion.Rol;

public interface RolRepositorio extends MongoRepository<Rol, String>{

	Optional<Rol> findByNombre(String nombre);
}
