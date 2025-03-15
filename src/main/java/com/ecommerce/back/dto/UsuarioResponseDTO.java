package com.ecommerce.back.dto;

import java.util.List;

public class UsuarioResponseDTO {

	private String usuario_id;
	private String nombre;
	private String password;
	private String email;
	private String direccion;
	private String telefono;
	private List<String> roles;
	
	public UsuarioResponseDTO() {
		super();
	}
	public UsuarioResponseDTO(String usuario_id, String nombre, String password, String email, String direccion,
			String telefono, List<String> roles) {
		super();
		this.usuario_id = usuario_id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.roles = roles;
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
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
	
}
