package com.valid.usuarios.object;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UsuarioRq {

	@NotNull(message = "Debe ingresar un valor")
	@Size(min = 1, message = "Debe ingresar un valor")
	@Pattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$", message = "Valor inválido")
	private String nombre;
	@NotNull(message = "Debe ingresar un valor")
	@Size(min = 1, message = "Debe ingresar un valor")
	@Pattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$", message = "Valor inválido")
	private String apellido;
	private boolean procesado;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean isProcesado() {
		return procesado;
	}

	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}
}
