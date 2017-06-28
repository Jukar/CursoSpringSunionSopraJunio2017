package com.curso.sunion.fullstack.presentacion.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.curso.sunion.fullstack.core.entidades.Usuario;

public interface UsuarioRestControlador {

	ResponseEntity<List<Usuario>> buscarAfines(String login);
	ResponseEntity<Usuario> buscarIdeal(String login);
	ResponseEntity<List<Usuario>> buscarUsuariosPorFiltro(Integer desde, Integer hasta);
	ResponseEntity<Usuario> login(String login, String password);
	ResponseEntity<Void> altaUsuario(Usuario usuario);
	ResponseEntity<Void> modificarDatosUsuario(Usuario usuario);
	ResponseEntity<Usuario> buscarUsuarioPorLogin(String login);
	ResponseEntity<Void> bajaUsuario(String login);
	ResponseEntity<Void> bajaUsuarios();
	
}
