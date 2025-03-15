package com.ecommerce.back.dto;

public class DetallePedidoDTO {

	private int cantidad;
	private double precio_unitario;
	private double subtotal;
	private String producto_id;
	
	public DetallePedidoDTO() {
		super();
	}
	public DetallePedidoDTO(int cantidad, double precio_unitario, double subtotal, String producto_id) {
		super();
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.subtotal = subtotal;
		this.producto_id = producto_id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public String getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(String producto_id) {
		this.producto_id = producto_id;
	}
	
	
}
