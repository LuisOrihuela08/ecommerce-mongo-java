package com.ecommerce.back.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.back.coleccion.Usuario;
import com.ecommerce.back.coleccion.Usuario_Rol;

public interface Usuario_RolRepositorio extends MongoRepository<Usuario_Rol, String>{

	List<Usuario_Rol> findByUsuario(Usuario usuario);
}
