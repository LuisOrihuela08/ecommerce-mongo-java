package com.ecommerce.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.back.coleccion.Estado;
import com.ecommerce.back.repositorio.EstadoRepositorio;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepositorio estadoRepositorio;
	
	public Estado saveEstado(Estado estado) {
		return estadoRepositorio.save(estado);
	}
	
	public List<Estado> listEstado(){
		return estadoRepositorio.findAll();
	}
}
