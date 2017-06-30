package com.curso.sunion.fullstack;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.curso.sunion.fullstack.core.dto.Usuario;

public class AplicacionClienteSpringMeetic {

	public static void main(String[] args) throws RestClientException, URISyntaxException {

		AnnotationConfigApplicationContext esteEsElContextoDeSpringConfiguradoConAnotaciones = new AnnotationConfigApplicationContext();

		esteEsElContextoDeSpringConfiguradoConAnotaciones.scan("com.curso.sunion.fullstack");

		RestTemplate restTemplate = esteEsElContextoDeSpringConfiguradoConAnotaciones.getBean(RestTemplate.class);

		ResponseEntity<Void> resultado = restTemplate.postForEntity(new URI("http://localhost:8080/Meetic/Usuario"),
				new Usuario("pepito", "pepito", "pepito", 30, 1.7f), Void.class);

		
		resultado.getHeaders().getLocation();
		
	}

}
