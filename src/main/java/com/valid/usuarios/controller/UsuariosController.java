package com.valid.usuarios.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valid.usuarios.business.UsuariosBusinessInt;
import com.valid.usuarios.model.Usuario;
import com.valid.usuarios.object.ActualizarUsuariosRq;
import com.valid.usuarios.object.Response;
import com.valid.usuarios.object.UsuarioRq;
import com.valid.usuarios.util.ValidatorUtil;

@Controller
public class UsuariosController {

	private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);
	
	private final UsuariosBusinessInt usuariosBusinessInt;
	
	@Autowired
	public UsuariosController(UsuariosBusinessInt usuariosBusinessInt) {
		this.usuariosBusinessInt = usuariosBusinessInt;
	}
	
	@RequestMapping("/usuarios")
	@ResponseBody
	public ModelAndView inicio() {
		return new ModelAndView("index.html");	
	}
	
	@RequestMapping("/usuarios/adicionar")
	public ModelAndView registrarUsuario(UsuarioRq request) {
		ModelAndView model = new ModelAndView("reg_usuario.html");
		try {
			ValidatorUtil.validateRequest(request);
			
			Response<UsuarioRq> response = this.usuariosBusinessInt.registrarUsuario(request);
			
			if (response.getStatus() == 200) {
				request = new UsuarioRq();
				model.addObject("mensaje", response.getMessage());
				model.addObject("usuario", request);
			} else {
				request = new UsuarioRq();
				model.addObject("mensaje", response.getMessage());
				model.addObject("usuario", request);
			}
		} catch (ConstraintViolationException e) {
			request = new UsuarioRq();
			model.addObject("mensaje", e.getMessage());
			model.addObject("usuario", request);
		}
		
		return model;
	}
	
	@RequestMapping("/usuarios/nuevo")
	public ModelAndView nuevoUsuario() {
		ModelAndView model = new ModelAndView("reg_usuario.html");
		UsuarioRq usuario = new UsuarioRq();
		model.addObject("usuario", usuario);
		
		return model;
	}
	
	@RequestMapping("/usuarios/procesar")
	public ModelAndView actualizar() {
		logger.info("Prueba servicio");
		List<Usuario> lista = null;
		ModelAndView model = new ModelAndView("consultar.html");
		
		Response<List<Usuario>> responseConsulta = this.usuariosBusinessInt.consultarUsuarios();
		
		if (responseConsulta.getStatus() == 200) {
			ActualizarUsuariosRq datos = new ActualizarUsuariosRq(responseConsulta.getBody());
			Response<String> response = this.usuariosBusinessInt.procesarUsuarios(datos);
			
			model.addObject("mensaje", response.getMessage());
			
			responseConsulta = this.usuariosBusinessInt.consultarUsuarios();
			
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
