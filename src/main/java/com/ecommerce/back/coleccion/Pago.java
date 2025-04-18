package com.ecommerce.back.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pago")
public class Pago {

	@Id
	private String pago_id;
	private String metodo_pago;
	private double monto;
	
	@DBRef
	private Pedido pedido;
	
	@DBRef
	private Estado estado;
	
	public Pago() {
		super();
	}

	public Pago(String pago_id, String metodo_pago, double monto, Pedido pedido, Estado estado) {
		super();
		this.pago_id = pago_id;
		this.metodo_pago = metodo_pago;
		this.monto = monto;
		this.pedido = pedido;
		this.estado = estado;
	}

	public String getPago_id() {
		return pago_id;
	}

	public void setPago_id(String pago_id) {
		this.pago_id = pago_id;
	}

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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Pago{" +
	            "pago_id='" + pago_id + '\'' +
	            ", metodo_pago='" + metodo_pago + '\'' +
	            ", monto='" + monto + '\'' +
	            ", pedido=" + pedido +
	            ", estado=" + estado +
	            '}';
	}
}
