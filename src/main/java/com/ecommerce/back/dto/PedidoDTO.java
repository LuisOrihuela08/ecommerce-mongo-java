package com.ecommerce.back.dto;

import java.time.LocalDate;
import java.util.List;

public class PedidoDTO {

	private LocalDate fecha;
	private double total;
	private String usuario_id;
	private List<String> detalleIds;
	
	public PedidoDTO() {
		super();
	}
	
	public PedidoDTO(LocalDate fecha, double total, String usuario_id, List<String> detalleIds) {
		super();
		this.fecha = fecha;
		this.total = total;
		this.usuario_id = usuario_id;
		this.detalleIds = detalleIds;
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
	
	public String getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}

	public List<String> getDetalleIds() {
		return detalleIds;
	}

	public void setDetalleIds(List<String> detalleIds) {
		this.detalleIds = detalleIds;
	}

	
	
	
}
