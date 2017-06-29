package com.curso.sunion.fullstack;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.curso.sunion.fullstack.dto.Persona;

public class ClientePersonaRestController {

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, Long> variables = new HashMap<>();
		
		variables.put("id", 1l);
		
		ResponseEntity<Persona> personaConId1 
				= restTemplate.getForEntity(
						"http://localhost:8080/00_HolaMundo/Persona/{id}", 
						Persona.class,
						variables);
		
		Persona persona = personaConId1.getBody();
		
		personaConId1.getHeaders().getContentType();
		
		personaConId1.getStatusCode();

	}

}
