package com.curso.sunion.fullstack.controladores;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.sunion.fullstack.dto.Persona;

@RestController
@RequestMapping("/Persona")
public class PersonaRestController {

	//@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // En
																												// el
																												// Accept
	public ResponseEntity<Persona> get(@PathVariable long id) {

		// invocar la logica de negocio
		// recoger el feedback
		Persona feedback = new Persona(id, "Pepito", 57);
		// y establecer la respuesta basandose en el feedback

		ResponseEntity<Persona> respuesta = new ResponseEntity<Persona>(feedback, HttpStatus.OK);

		return respuesta;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> getAll(@RequestParam(required=false) String nombre) {
		// invocar la logica de negocio
		// recoger el feedback
		// y establecer la respuesta basandose en el feedback

		return null;
	}
	
	@RequestMapping(path = "/{id}/padre", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> getPadre(@PathVariable long id) {
		// invocar la logica de negocio
		// recoger el feedback
		// y establecer la respuesta basandose en el feedback

		return null;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) // En
																								// el
																								// ContentType
																								// tiene
																								// que
																								// venir
																								// application/json
	public ResponseEntity<Void> post(@RequestBody Persona persona) throws URISyntaxException {

		// invocar la logica de negocio
		// recoger el feedback
		long feedback = 123;
		// y establecer la respuesta basandose en el feedback

		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(new URI("http://localhost:8080/00_HolaMundo/Persona/" + feedback));
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE) // En
																								// el
																								// ContentType
																								// tiene
																								// que
																								// venir
																								// application/json
	public ResponseEntity<Persona> put(@RequestBody Persona persona) {
		// invocar la logica de negocio
		// recoger el feedback
		// y establecer la respuesta basandose en el feedback

		return null;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Persona> delete(@PathVariable long id) {
		// invocar la logica de negocio
		// recoger el feedback
		// y establecer la respuesta basandose en el feedback

		return null;
	}

}
