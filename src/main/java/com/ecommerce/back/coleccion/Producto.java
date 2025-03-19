package com.ecommerce.back.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "producto")
public class Producto {

	@Id
	private String producto_id;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	
	@DBRef
	private Categoria categoria;
	
	public Producto() {
		super();
	}

	public Producto(String producto_id, String nombre, String descripcion, double precio, int stock,
			Categoria categoria) {
		super();
		this.producto_id = producto_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
	}

	public String getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(String producto_id) {
		this.producto_id = producto_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Producto{" +
	            "producto_id='" + producto_id + '\'' +
	            ", nombre='" + nombre + '\'' +
	            ", descripcion='" + descripcion + '\'' +
	            ", precio=" + precio +
	            ", stock=" + stock +
	            ", categoria=" + categoria +
	            '}';
	}
}
