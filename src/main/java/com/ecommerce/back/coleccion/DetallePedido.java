package com.ecommerce.back.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "detalle_pedido")
public class DetallePedido {

	@Id
	private String detalle_pedido_id;
	private int cantidad;
	private double precio_unitario;
	private double subtotal;
	
	@DBRef
	private Producto producto;

	public String getDetalle_pedido_id() {
		return detalle_pedido_id;
	}

	public void setDetalle_pedido_id(String detalle_pedido_id) {
		this.detalle_pedido_id = detalle_pedido_id;
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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	@Override
	public String toString() {
		return "DetallePedido{" +
	            "detalle_pedido_id='" + detalle_pedido_id + '\'' +
	            ", cantidad='" + cantidad + '\'' +
	            ", precio_unitario='" + precio_unitario + '\'' +
	            ", subtotal=" + subtotal +
	            ", producto=" + producto +
	            '}';
	}
	
}
