package com.valid.usuarios.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.valid.usuarios.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query(value = ("SELECT u FROM USUARIO u "))
	Optional<List<Usuario>> getList();
	
	@Query(value = ("UPDATE USUARIO u SET PROCESADO = true WHERE u.id = ?1"))
	void updateUsuarios(Integer id);
}
