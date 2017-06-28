package com.curso.sunion.fullstack.core.entidades;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private String nombre;
	private String login;
	private String password;
	private int edad;
	private float altura;
	
	public Usuario(String nombre, String login, String password, int edad, float altura) {
		super();
		this.nombre = nombre;
		this.login = login;
		this.password = password;
		this.edad = edad;
		this.altura = altura;
	}

	public Usuario() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", login=" + login + ", password=" + password + ", edad=" + edad
				+ ", altura=" + altura + "]";
	}
}
