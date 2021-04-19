package com.valid.usuarios.business;

import com.valid.usuarios.object.ActualizarUsuariosRq;
import com.valid.usuarios.object.Response;
import com.valid.usuarios.object.UsuarioRq;

public interface UsuariosBusinessInt {

	/**
	 * Método encargado de reistrar un usuario en base de datos
	 * @param <T> Tipo de dato en el cuerpo del response
	 * @param request Objeto con los datos del usuario
	 * @return Objeto con la respuesta del servicio
	 */
	public <T> Response<T> registrarUsuario(UsuarioRq request);
	
	/**
	 * Método encargado de procesar todos los usuarios
	 * @param request Objeto con los usuarios
	 * @return Objeto con la respuesta del servicio
	 */
	public Response<String> procesarUsuarios(ActualizarUsuariosRq request);
	
	/**
	 * Método encargado de consultar los usuariios en base de datos
	 * @param <T> Tipo de dato en el cuerpo del response
	 * @return Objeto con la respuesta del servicio
	 */
	public <T> Response<T> consultarUsuarios();
}
