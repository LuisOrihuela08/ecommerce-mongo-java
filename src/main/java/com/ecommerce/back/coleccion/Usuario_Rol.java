package com.ecommerce.back.coleccion;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario_rol")
public class Usuario_Rol {

	@Id
	private String usuario_rol_id;
	
	@DBRef
	private Usuario usuario;
	
	@DBRef
	private Rol rol;


	public String getUsuario_rol_id() {
		return usuario_rol_id;
	}

	public void setUsuario_rol_id(String usuario_rol_id) {
		this.usuario_rol_id = usuario_rol_id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "UsuarioRol{" +
	            "usuario_rol_id='" + usuario_rol_id + '\'' +
	            ", usuario='" + usuario + '\'' +
	            ", rol='" + rol  +
	            '}';
	}
	
}
