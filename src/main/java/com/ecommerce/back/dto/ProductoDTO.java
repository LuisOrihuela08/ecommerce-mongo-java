package com.ecommerce.back.dto;

public class ProductoDTO {

	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	private String categoria_id;
	
	public ProductoDTO() {
		super();
	}
	public ProductoDTO(String nombre, String descripcion, double precio, int stock, String categoria_id) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.categoria_id = categoria_id;
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
	public String getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(String categoria_id) {
		this.categoria_id = categoria_id;
	}
	
	
}
