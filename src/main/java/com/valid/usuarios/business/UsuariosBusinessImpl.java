package com.valid.usuarios.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valid.usuarios.model.Usuario;
import com.valid.usuarios.object.ActualizarUsuariosRq;
import com.valid.usuarios.object.Response;
import com.valid.usuarios.object.UsuarioRq;
import com.valid.usuarios.repository.UsuarioRepository;

@Service
public class UsuariosBusinessImpl implements UsuariosBusinessInt {

	private static final Logger log = LoggerFactory.getLogger(UsuariosBusinessImpl.class);
	
	@Autowired
    private UsuarioRepository repository;
	
	/**
	 * Método encargado de reistrar un usuario en base de datos
	 */
	@SuppressWarnings("unchecked")
	public <T> Response<T> registrarUsuario(UsuarioRq request) {
		try {
			
			Usuario usuario = new Usuario(request.getNombre(), request.getApellido());
			
			// Se guarda el usuario
			repository.save(usuario);
			
		return (Response<T>) new Response<UsuarioRq>(200, "Success", request);
			
		} catch(Exception e) {
			log.error("Business error", e);
			return (Response<T>) new Response<String>(500, "Error");
		}
	}

	/**
	 * Método encargado de procesar todos los usuarios
	 */
	public Response<String> procesarUsuarios(ActualizarUsuariosRq request) {
		try {
			for (Usuario usuario : request.getLista()) {
				usuario.setProcesado(Boolean.TRUE);
				repository.save(usuario);
			}
			
			return new Response<String>(200, "Success", "Ok");
			
		} catch(Exception e) {
			log.error("Business error", e);
			return new Response<String>(500, "Error");
		}
	}

	/**
	 * Método encargado de consultar los usuariios en base de datos
	 */
	@SuppressWarnings("unchecked")
	public <T> Response<T> consultarUsuarios() {
		try {
			
			List<Usuario> usuarios = repository.getList().get();
			
			return (Response<T>) new Response<List<Usuario>>(200, "Success", usuarios);
			
		} catch(Exception e) {
			log.error("Business error", e);
			return (Response<T>) new Response<String>(500, "Error");
		}
	}
}
