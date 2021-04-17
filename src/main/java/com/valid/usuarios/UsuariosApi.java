package com.valid.usuarios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsuariosApi {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(UsuariosApi.class);
		log.info("Start Prueba Api");
		SpringApplication.run(UsuariosApi.class, args);
	}
}
