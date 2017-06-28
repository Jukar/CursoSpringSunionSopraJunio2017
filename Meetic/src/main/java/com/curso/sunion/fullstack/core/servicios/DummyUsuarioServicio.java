package com.curso.sunion.fullstack.core.servicios;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.sunion.fullstack.core.entidades.Usuario;

@Service
public class DummyUsuarioServicio implements UsuarioServicio {

	private List<Usuario> usuarios = Arrays.asList(new Usuario[]{
		new Usuario("Juan", "juan", "juan", 22, 2.00f),
		new Usuario("Victor", "victor", "victor", 24, 1.80f),
		new Usuario("Maria", "maria", "maria", 32, 1.65f),
		new Usuario("Pedro", "pedro", "pedro", 20, 1.70f)
	});
	
	public List<Usuario> buscarAfines(Usuario usuario) {
		return usuarios;
	}

	public Usuario buscarIdeal(Usuario usuario) {
		return usuario;
	}

	public List<Usuario> buscarUsuarios() {
		return usuarios;
	}

	public Usuario login(String login, String password) {
		return new Usuario(login, login, password, 22, 2.00f);
	}

	public void altaUsuario(Usuario usuario) {

	}

	public Usuario buscarUsuarioPorLogin(String login) {
		return new Usuario(login, login, login, 22, 2.00f);
	}

	public List<Usuario> buscarUsuariosEntreEdades(Integer desde, Integer hasta) {
		return usuarios;
	}

}
