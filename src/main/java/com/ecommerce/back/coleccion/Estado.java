package com.ecommerce.back.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estado")
public class Estado {

	@Id
	private String estado_id;
	private String nombre;
	
	
	public Estado() {
		super();
	}
	public Estado(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	public String getEstado_id() {
		return estado_id;
	}
	public void setEstado_id(String estado_id) {
		this.estado_id = estado_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Método toString para que se vea bien en los logs
    @Override
    public String toString() {
        return "Estado(estado_id=" + estado_id + ", nombre=\"" + nombre + "\")";
    }
	
}
