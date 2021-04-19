package com.valid.usuarios.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.valid.usuarios.business.UsuariosBusinessInt;
import com.valid.usuarios.model.Usuario;
import com.valid.usuarios.object.ActualizarUsuariosRq;
import com.valid.usuarios.object.Response;
import com.valid.usuarios.object.UsuarioRq;
import com.valid.usuarios.util.ValidatorUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags = "Usuarios Controller HTML")
public class UsuariosController {

	private final UsuariosBusinessInt usuariosBusinessInt;
	
	@Autowired
	public UsuariosController(UsuariosBusinessInt usuariosBusinessInt) {
		this.usuariosBusinessInt = usuariosBusinessInt;
	}
	
	@RequestMapping("/usuarios")
	@ApiOperation(value = "Página de inicio", tags = "Usuarios Controller HTML")
	public ModelAndView inicio() {
		return new ModelAndView("index.html");	
	}
	
	@RequestMapping("/usuarios/adicionar")
	@ApiOperation(value = "Operación para registrar un usuario", tags = "Usuarios Controller HTML")
	public ModelAndView registrarUsuario(UsuarioRq request) {
		ModelAndView model = new ModelAndView("reg_usuario.html");
		try {
			// Se validan los campos del request 
			ValidatorUtil.validateRequest(request);
			
			Response<UsuarioRq> response = this.usuariosBusinessInt.registrarUsuario(request);
			
			// Se asignan los datos para la vista html
			request = new UsuarioRq();
			model.addObject("mensaje", response.getMessage());
			model.addObject("usuario", request);
		} catch (ConstraintViolationException e) {
			request = new UsuarioRq();
			model.addObject("mensaje", e.getMessage());
			model.addObject("usuario", request);
		}
		
		return model;
	}
	
	@RequestMapping("/usuarios/nuevo")
	@ApiOperation(value = "Operación para redireccionar a la página de registarr un usuario", tags = "Usuarios Controller HTML")
	public ModelAndView nuevoUsuario() {
		ModelAndView model = new ModelAndView("reg_usuario.html");
		UsuarioRq usuario = new UsuarioRq();
		model.addObject("usuario", usuario);
		
		return model;
	}
	
	@RequestMapping("/usuarios/procesar")
	@ApiOperation(value = "Operación para actualizar todos los usuarios", tags = "Usuarios Controller HTML")
	public ModelAndView actualizar() {
		
		List<Usuario> lista = null;
		ModelAndView model = new ModelAndView("consultar.html");
		
		// Se consultan los usuarios registradoe n base de datos
		Response<List<Usuario>> responseConsulta = this.usuariosBusinessInt.consultarUsuarios();
		
		// Se verifica s }i la respuesta es correcta
		if (responseConsulta.getStatus() == 200) {
			// Se asigna la lista y actualizan registros
			ActualizarUsuariosRq datos = new ActualizarUsuariosRq(responseConsulta.getBody());
			Response<String> response = this.usuariosBusinessInt.procesarUsuarios(datos);
			
			// Se asigna la respuesta del proceso
			model.addObject("mensaje", response.getMessage());
			
			// Sew consultans los usuarios actualizados
			responseConsulta = this.usuariosBusinessInt.consultarUsuarios();
			
			// Se verifica la respuesta de la consulta
			if (response.getStatus() == 200) {
				lista = responseConsulta.getBody();
			} else {
				model.addObject("mensaje", "Error consultando usuarios luego de procesar");
			}
			
			model.addObject("usuarioList", lista);
		} else {
			model.addObject("usuarioList", lista);
			model.addObject("mensaje", "Error");
		}
		
		return model;
	}
	
	@RequestMapping("/usuarios/obtenerTodos")
	@ApiOperation(value = "Operación para consultar todos los usuarios", tags = "Usuarios Controller HTML")
	public ModelAndView consultarUsuarios() {
		List<Usuario> lista = null;
		ModelAndView model = new ModelAndView("consultar.html");
		Response<List<Usuario>> response = this.usuariosBusinessInt.consultarUsuarios();
		
		if (response.getStatus() == 200) {
			lista = response.getBody();
		} else {
			model.addObject("mensaje", response.getMessage());
		}
		
		model.addObject("usuarioList", lista);
		return model;
	}
}
