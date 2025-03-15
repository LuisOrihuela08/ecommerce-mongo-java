package com.ecommerce.back.dto;

public class PagoDTO {

	private String metodo_pago;
	private double monto;
	private String pedido_id;
	private String estado_id;
	
	public String getMetodo_pago() {
		return metodo_pago;
	}
	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(String pedido_id) {
		this.pedido_id = pedido_id;
	}
	public String getEstado_id() {
		return estado_id;
	}
	public void setEstado_id(String estado_id) {
		this.estado_id = estado_id;
	}
	
	
}
