package com.valid.usuarios.object;

import java.util.List;

import com.valid.usuarios.model.Usuario;

public class ActualizarUsuariosRq {

	List<Usuario> lista;

	public ActualizarUsuariosRq(List<Usuario> lista) {
		super();
		this.lista = lista;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
}
