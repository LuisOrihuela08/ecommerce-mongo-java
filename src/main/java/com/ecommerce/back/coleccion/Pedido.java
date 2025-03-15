package com.ecommerce.back.coleccion;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedido")
public class Pedido {

	@Id
	private String pedido_id;
	private LocalDate fecha;
	private double total;
	
	@DBRef
	private Usuario usuario;
	
	@DBRef
	private List<DetallePedido> detallePedido;
	
	public Pedido() {
		super();
	}

	public Pedido(String pedido_id, LocalDate fecha, double total, Usuario usuario, List<DetallePedido> detallePedido) {
		super();
		this.pedido_id = pedido_id;
		this.fecha = fecha;
		this.total = total;
		this.usuario = usuario;
		this.detallePedido = detallePedido;
	}

	public String getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(String pedido_id) {
		this.pedido_id = pedido_id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}	
	
}
