package com.ecommerce.back.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario {

	@Id
	private String usuario_id;
	private String nombre;
	private String password;
	private String email;
	private String direccion;
	private String telefono;
	
	@Transient
	private boolean admin;
	
	public Usuario() {
		super();
	}
	public Usuario(String usuario_id, String nombre, String password, String email, String direccion, String telefono) {
		super();
		this.usuario_id = usuario_id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public String getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "Usuario{" +
	            "usuario_id='" + usuario_id + '\'' +
	            ", nombre='" + nombre + '\'' +
	            ", password='" + password + '\'' +
	            ", email=" + email +
	            ", direccion=" + direccion +
	            ", telefono=" + telefono +
	            '}';
	}
	
}
