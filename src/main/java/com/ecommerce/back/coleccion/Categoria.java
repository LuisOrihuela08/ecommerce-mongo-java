package com.ecommerce.back.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categoria")
public class Categoria {

	@Id
	private String categoria_id;
	private String nombre;
	
	public Categoria() {
		super();
	}
	public Categoria(String categoria_id, String nombre) {
		super();
		this.categoria_id = categoria_id;
		this.nombre = nombre;
	}
	public String getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(String categoria_id) {
		this.categoria_id = categoria_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Categoria(categoria_id=" + categoria_id +
				", nombre=\"" + nombre + "\")";
	}
	
	
}
