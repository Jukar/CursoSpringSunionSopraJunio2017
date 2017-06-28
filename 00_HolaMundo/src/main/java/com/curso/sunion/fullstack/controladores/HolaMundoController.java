package com.curso.sunion.fullstack.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

import com.curso.sunion.fullstack.dto.Persona;
import com.curso.sunion.fullstack.modelo.negocio.Negocio;

@Controller
@RequestMapping("/Saludos")
public class HolaMundoController {
	
	private Negocio negocio = null;
	
	//Inyeccion por Constructor
	@Autowired
	public HolaMundoController(Negocio negocio) {
		super();
		this.negocio = negocio;
	}
	
	//Inyeccion por setter
	/*public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
	}*/

	@RequestMapping("/Saludar")
	public String saludar(Persona persona, 
			HttpServletRequest request, Model modelo){
		
		modelo.addAttribute("saludo", negocio.saludar(persona));
		
		/*Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setEdad(Integer.valueOf(edad));*/
		
		//Esto no acopla con la tecnologia de vista, necesita de un ViewResolver
		return "saludo";
	}
	
	

	@RequestMapping("/Despedir")
	public View despedir(Model modelo){
		
		modelo.addAttribute("saludo", negocio.despedir());
		
		//Nos acopla con la tecnologia de Vista a emplear
		return new JstlView("/WEB-INF/views/saludo.jsp");
	}
	
	@RequestMapping("/Bienvenida")
	public ModelAndView bienvenida(){
		
		Map<String, Object> modelo = new HashMap<>();
		
		modelo.put("saludo", negocio.bienvenida());
		
		JstlView view = new JstlView("/WEB-INF/views/saludo.jsp");
		
		//Nos acopla con la tecnologia de Vista a emplear
		//return new ModelAndView("saludo", modelo);
		return new ModelAndView(view, modelo);
	}
	
}
