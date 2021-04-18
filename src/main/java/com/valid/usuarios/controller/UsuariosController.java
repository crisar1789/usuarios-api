package com.valid.usuarios.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valid.usuarios.model.Usuario;
import com.valid.usuarios.repository.UsuarioRepository;

@Controller
public class UsuariosController {

	private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);
	
	@Autowired
	private UsuarioRepository repository;
	
	@RequestMapping("/")
	@ResponseBody
	public ModelAndView consultarUsuarios() {
		logger.info("Consulta controller");
		ModelAndView model = new ModelAndView("index.html");
		List<Usuario> lista = (List<Usuario>) repository.findAll();
		model.addObject("usuarioList", lista);
		return model;
		//return (List<Usuario>) repository.findAll();	
	}
}
