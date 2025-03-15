package com.ecommerce.back.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rol")
public class Rol {

	@Id
	private String rol_id;
	private String nombre;
	
	public Rol() {
		super();
	}
	public Rol(String rol_id, String nombre) {
		super();
		this.rol_id = rol_id;
		this.nombre = nombre;
	}
	public String getRol_id() {
		return rol_id;
	}
	public void setRol_id(String rol_id) {
		this.rol_id = rol_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Producto{" + 
				"rol_id='" + rol_id + '\'' +
				", nombre='" + nombre +
				'}';
	}
	
}
