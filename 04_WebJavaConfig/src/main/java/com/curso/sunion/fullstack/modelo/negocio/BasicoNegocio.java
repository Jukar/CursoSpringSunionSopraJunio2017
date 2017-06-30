package com.curso.sunion.fullstack.modelo.negocio;

import org.springframework.stereotype.Component;

import com.curso.sunion.fullstack.dto.Persona;

@Component
public class BasicoNegocio implements Negocio {

	/* (non-Javadoc)
	 * @see com.curso.sunion.fullstack.modelo.negocio.Negocio#saludar(com.curso.sunion.fullstack.dto.Persona)
	 */
	@Override
	public String saludar(Persona persona) {
		return "Hola " + persona.getNombre() + "!!!!!";
	}

	/* (non-Javadoc)
	 * @see com.curso.sunion.fullstack.modelo.negocio.Negocio#despedir()
	 */
	@Override
	public String despedir() {
		return "Adios!";
	}

	/* (non-Javadoc)
	 * @see com.curso.sunion.fullstack.modelo.negocio.Negocio#bienvenida()
	 */
	@Override
	public String bienvenida() {
		return "Bienbenido a este sitio web";
	}

}
