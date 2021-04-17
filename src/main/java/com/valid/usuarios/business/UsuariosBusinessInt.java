package com.valid.usuarios.business;

import com.valid.usuarios.object.ActualizarUsuariosRq;
import com.valid.usuarios.object.Response;
import com.valid.usuarios.object.UsuarioRq;

public interface UsuariosBusinessInt {

	public <T> Response<T> registrarUsuario(UsuarioRq request);
	
	public Response<String> procesarUsuarios(ActualizarUsuariosRq request);
	
	public <T> Response<T> consultarUsuarios();
}
