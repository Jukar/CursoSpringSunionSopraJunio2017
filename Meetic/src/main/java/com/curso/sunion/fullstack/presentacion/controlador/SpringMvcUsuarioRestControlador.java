package com.curso.sunion.fullstack.presentacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.sunion.fullstack.core.entidades.Usuario;
import com.curso.sunion.fullstack.core.servicios.UsuarioServicio;

@RestController
@RequestMapping("/Usuario")
public class SpringMvcUsuarioRestControlador implements UsuarioRestControlador {

	private UsuarioServicio servicio;//Dependencia
	
	@Autowired
	public SpringMvcUsuarioRestControlador(UsuarioServicio servicio) {
		super();
		this.servicio = servicio;
	}

	@RequestMapping(
			path="/{login}/afines", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> buscarAfines(
						@PathVariable String login) {
		
		Usuario usuario = servicio
				.buscarUsuarioPorLogin(login);
		List<Usuario> afines = servicio
				.buscarAfines(usuario);
		
		//o
		
		//servicio.buscarAfines(login);
		
		return new ResponseEntity<List<Usuario>>(
								afines,HttpStatus.OK);
	}

	@RequestMapping(
			path="/{login}/ideal", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarIdeal(
					@PathVariable String login) {
		
		Usuario usuario = servicio.buscarUsuarioPorLogin(login);
		
		Usuario ideal = servicio.buscarIdeal(usuario);
		
		return new ResponseEntity<Usuario>(ideal,HttpStatus.OK);
	}

	@RequestMapping(
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> buscarUsuariosPorFiltro(
			@RequestParam(required=false) Integer desde, 
			@RequestParam(required=false) Integer hasta) {

		try {
		
		if(desde == null && hasta == null){
			List<Usuario> usuarios = 
					servicio.buscarUsuarios();
			return new ResponseEntity<List<Usuario>>(
								usuarios, HttpStatus.OK);
		} else if (desde != null && hasta != null) {
			//invocar la logica del servicio para buscar entre Edades
			List<Usuario> usuarios = 
					servicio.buscarUsuariosEntreEdades(
												desde, hasta);
			return new ResponseEntity<List<Usuario>>(
					usuarios, HttpStatus.OK);
		} else {
			//throw new UnsupportedOperationException();
			
			//o mas elegante
			
			return new ResponseEntity<List<Usuario>>(HttpStatus.NOT_IMPLEMENTED);
		}
		} catch(Exception ex){
			return new ResponseEntity<List<Usuario>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Esto no cumple con REST, los login, no se se hacen con REST normalmente
	@RequestMapping(
			path="/login", 
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> login(
			@RequestParam(required=true) String login, 
			@RequestParam(required=true) String password) {
		
		Usuario usuario = servicio.login(login, password);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@RequestMapping(
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> altaUsuario(@RequestBody Usuario usuario) {
		// TODO Auto-generated method stub
		System.out.println(usuario);
		return null;
	}

	@RequestMapping(
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> modificarDatosUsuario(@RequestBody Usuario usuario){
		return null;
	}

	@RequestMapping(
			path="/{login}", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarUsuarioPorLogin(@PathVariable String login) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(
			path="/{login}", 
			method=RequestMethod.DELETE)
	public ResponseEntity<Void> bajaUsuario(@PathVariable String login) {
		return null;
	}
	
	@RequestMapping(
			method=RequestMethod.DELETE)
	public ResponseEntity<Void> bajaUsuarios() {
		return null;
	}
}
