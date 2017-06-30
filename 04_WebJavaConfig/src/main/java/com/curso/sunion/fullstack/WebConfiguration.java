package com.curso.sunion.fullstack;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfiguration implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext webApplicationContext 
				= new AnnotationConfigWebApplicationContext();
		
		webApplicationContext.scan(this.getClass().getPackage().getName());
		
		Dynamic servlet = servletContext
			.addServlet(
					"spring", 
					new DispatcherServlet(webApplicationContext));
		
		servlet.addMapping("/");
		
		servlet.setLoadOnStartup(1);
		
	}

}
