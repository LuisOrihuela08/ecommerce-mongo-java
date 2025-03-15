package com.ecommerce.back.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.back.coleccion.Rol;
import com.ecommerce.back.coleccion.Usuario;
import com.ecommerce.back.coleccion.Usuario_Rol;
import com.ecommerce.back.dto.UsuarioResponseDTO;
import com.ecommerce.back.repositorio.RolRepositorio;
import com.ecommerce.back.repositorio.UsuarioRepositorio;
import com.ecommerce.back.repositorio.Usuario_RolRepositorio;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private RolRepositorio rolRepositorio;
	
	@Autowired
	private Usuario_RolRepositorio usuario_RolRepositorio;
	
	
	public List<UsuarioResponseDTO> listarUsuariosRoles(){
		List<Usuario> usuarios = usuarioRepositorio.findAll();
		
		return usuarios.stream().map(usuario -> {
			List<Usuario_Rol> usuarioRoles = usuario_RolRepositorio.findByUsuario(usuario);
			
			List<String> roles = usuarioRoles.stream()
					.map(usuarioRol -> usuarioRol.getRol().getNombre())
					.collect(Collectors.toList());
			
			return new UsuarioResponseDTO(usuario.getUsuario_id(),
					              usuario.getNombre(),
					              usuario.getPassword(),
					              usuario.getEmail(),
					              usuario.getDireccion(),
					              usuario.getTelefono(),
					              roles);
		}).collect(Collectors.toList());
	}
	
	public Usuario saveUsuario(Usuario usuario) {
		
		Usuario usuarioGuardado = usuarioRepositorio.save(usuario);
		
		// Obtener los roles del usuario
        List<Rol> roles = getRoles(usuario);
        
     // Crear y guardar relaciones en usuario_rol
        for (Rol rol : roles) {
            Usuario_Rol usuarioRol = new Usuario_Rol();
            usuarioRol.setUsuario(usuarioGuardado);
            usuarioRol.setRol(rol);
            usuario_RolRepositorio.save(usuarioRol);
        }

        return usuarioGuardado;
	}
	//Guardar una lista de Roles
	private List<Rol> getRoles(Usuario usuario){
		List<Rol> roles = new ArrayList<>();
		Optional<Rol> rolOptional = rolRepositorio.findByNombre("ROLE_USER");
		rolOptional.ifPresent(roles::add);
		
		if (usuario.isAdmin()) {
			Optional<Rol> adminRolOptional = rolRepositorio.findByNombre("ROLE_ADMIN");
			adminRolOptional.ifPresent(role -> roles.add(role));
		}
		return roles;
	}
}
