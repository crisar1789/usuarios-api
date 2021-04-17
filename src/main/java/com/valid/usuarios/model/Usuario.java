package com.valid.usuarios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name="ID", unique=true, nullable=false)
	private Integer id;
	@Column(name="NOMBRE", unique=true, nullable=false)
	private String nombre;
	@Column(name="APELLIDO", unique=true, nullable=false)
	private String apellido;
	@Column(name="PROCESADO")
	private boolean procesado;
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.procesado = Boolean.FALSE;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
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
