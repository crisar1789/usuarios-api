package com.valid.usuarios.rest;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valid.usuarios.business.UsuariosBusinessInt;
import com.valid.usuarios.object.ActualizarUsuariosRq;
import com.valid.usuarios.object.Response;
import com.valid.usuarios.object.UsuarioRq;
import com.valid.usuarios.util.ValidatorUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/usuarios")
@RestController
@Api(tags = "Usuarios Rest", produces = "application/json")
public class UsuarioRest {

	private final UsuariosBusinessInt usuariosBusinessInt;
	
	@Autowired
	public UsuarioRest(UsuariosBusinessInt usuariosBusinessInt) {
		this.usuariosBusinessInt = usuariosBusinessInt;
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Operación para registrar un usuario", tags = "Usuarios Rest")
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public <T> Response<T> registrarUsuario(
			@ApiParam(value = "Objeto con los datos del usuario") @RequestBody UsuarioRq request) {
		try {
			// Se validan los campos del request 
			ValidatorUtil.validateRequest(request);
			
			return this.usuariosBusinessInt.registrarUsuario(request);
		} catch (ConstraintViolationException e) {
			return (Response<T>) new Response<String>(400, "BadRequest", e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Operación para consultar los usuarios registrados", tags = "Usuarios Rest")
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public <T> Response<T> consultar() {
		try {
			return this.usuariosBusinessInt.consultarUsuarios();
		} catch (ConstraintViolationException e) {
			return (Response<T>) new Response<String>(400, "BadRequest", e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "Operación para actualizar los usuarios", tags = "Usuarios Rest")
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public <T> Response<T> actualizar(
			@ApiParam(value = "Objeto con la lista de usuarios") @RequestBody ActualizarUsuariosRq request) {
		try {
			return (Response<T>) this.usuariosBusinessInt.procesarUsuarios(request);
		} catch (ConstraintViolationException e) {
			return (Response<T>) new Response<String>(400, "BadRequest", e.getMessage());
		}
	}
}
