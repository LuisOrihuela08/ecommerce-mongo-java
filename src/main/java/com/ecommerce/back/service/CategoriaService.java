package com.ecommerce.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.back.coleccion.Categoria;
import com.ecommerce.back.repositorio.CategoriRepositorio;

@Service
public class CategoriaService {

	@Autowired
	private CategoriRepositorio categoriRepositorio;
	
	public List<Categoria> listCategoria(){
		return categoriRepositorio.findAll();
	}
	
	public Categoria saveCategoria(Categoria categoria) {
		return categoriRepositorio.save(categoria);
	}
}
