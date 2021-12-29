package com.trnetwork.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@CrossOrigin(origins = "*")
@Table(name= "jgm_docente")
public class Docente {
	
	@Id
	private long matricula;
	private String nombre;
	private String paterno;
	private String materno;
	private String contrasenia;

	public Docente() {
		
	}

	public Docente(long matricula, String nombre, String paterno, String materno, String contrasenia) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.contrasenia = contrasenia;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Docente [matricula=" + matricula + ", nombre=" + nombre + ", paterno=" + paterno + ", materno="
				+ materno + ", contrasenia=" + contrasenia + "]";
	}
	
	
	
}
