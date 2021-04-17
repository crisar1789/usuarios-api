package com.valid.usuarios.rest;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valid.usuarios.business.UsuariosBusinessInt;
import com.valid.usuarios.object.ActualizarUsuariosRq;
import com.valid.usuarios.object.Response;
import com.valid.usuarios.object.UsuarioRq;

@RestController
public class UsuarioRest {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioRest.class);
	private final UsuariosBusinessInt usuariosBusinessInt;
	
	@Autowired
	public UsuarioRest(UsuariosBusinessInt usuariosBusinessInt) {
		this.usuariosBusinessInt = usuariosBusinessInt;
	}

	@RequestMapping(value = "/work", method = RequestMethod.GET)
	public Response getEmployee() {
		logger.info("Prueba servicio");
		
		return new Response(200, "Work!");
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public <T> Response<T> registrarUsuario(@RequestBody UsuarioRq request) {
		logger.info("Prueba servicio");
		
		try {
			//ValidatorUtil.validateRequest(empleadoRq);
			
			return this.usuariosBusinessInt.registrarUsuario(request);
		} catch (ConstraintViolationException e) {
			return (Response<T>) new Response<String>(400, "BadRequest", e.getMessage());
		}
		
		//return new Response(200, "Work!", request);
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public <T> Response<T> consultar() {
		logger.info("Prueba servicio");
		
		try {
			//ValidatorUtil.validateRequest(empleadoRq);
			
			return this.usuariosBusinessInt.consultarUsuarios();
		} catch (ConstraintViolationException e) {
			return (Response<T>) new Response<String>(400, "BadRequest", e.getMessage());
		}
		
		//return new Response(200, "Work!", request);
	}
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public <T> Response<T> actualizar(@RequestBody ActualizarUsuariosRq request) {
		logger.info("Prueba servicio");
		
		try {
			//ValidatorUtil.validateRequest(empleadoRq);
			logger.info("Prueba servicio");
			return (Response<T>) this.usuariosBusinessInt.procesarUsuarios(request);
		} catch (ConstraintViolationException e) {
			return (Response<T>) new Response<String>(400, "BadRequest", e.getMessage());
		}
		
		//return new Response(200, "Work!", request);
	}
}
