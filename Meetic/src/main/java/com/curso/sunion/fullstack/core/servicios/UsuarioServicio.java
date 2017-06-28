package com.curso.sunion.fullstack.core.servicios;

import java.util.List;

import com.curso.sunion.fullstack.core.entidades.Usuario;

public interface UsuarioServicio {
	List<Usuario> buscarAfines(Usuario usuario);
	Usuario buscarIdeal(Usuario usuario);
	List<Usuario> buscarUsuarios();
	Usuario login(String login, String password);
	void altaUsuario(Usuario usuario);
	Usuario buscarUsuarioPorLogin(String login);
	List<Usuario> buscarUsuariosEntreEdades(Integer desde, Integer hasta);
}
