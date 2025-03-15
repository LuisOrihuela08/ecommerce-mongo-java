package com.ecommerce.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.back.coleccion.Rol;
import com.ecommerce.back.repositorio.RolRepositorio;

@Service
public class RolService {

	@Autowired
	private RolRepositorio rolRepositorio;
	
	public List<Rol> listAllRol(){
		return rolRepositorio.findAll();
	}
	
	public Rol saveRol(Rol rol) {
		return rolRepositorio.save(rol);
	}
}
