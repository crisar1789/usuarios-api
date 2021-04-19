package com.valid.usuarios.object;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.valid.usuarios.model.Usuario;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Objeto de petición para actualizar los usuarios")
public class ActualizarUsuariosRq {

	@NotNull(message = "Debe ingresar datos")
	@ApiModelProperty(value = "lista de usuarios a actualizar", required = true)
	private List<Usuario> lista;

	public ActualizarUsuariosRq(List<Usuario> lista) {
		super();
		this.lista = lista;
	}

	public List<Usuario> getLista() {
		return lista;
	}
}
