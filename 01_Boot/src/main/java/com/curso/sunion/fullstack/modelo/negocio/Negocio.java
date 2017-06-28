package com.curso.sunion.fullstack.modelo.negocio;

import com.curso.sunion.fullstack.dto.Persona;

public interface Negocio {

	String saludar(Persona persona);

	String despedir();

	String bienvenida();

}