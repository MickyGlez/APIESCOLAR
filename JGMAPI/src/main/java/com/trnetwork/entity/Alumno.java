package com.trnetwork.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jgm_alumno")
public class Alumno {

	@Id	
	private long matricula;
	private String nombre;
	private String paterno;
	private String materno;
	private Date fechanac;
	private String direccion;
	private String genero;
	private String contrasenia;
	
	public Alumno() {
		
	}

	public Alumno(long matricula, String nombre, String paterno, String materno, Date fechanac, String direccion,
			String genero, String contrasenia) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.fechanac = fechanac;
		this.direccion = direccion;
		this.genero = genero;
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

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Alumno [matricula=" + matricula + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno
				+ ", fechanac=" + fechanac + ", direccion=" + direccion + ", genero=" + genero + ", contrasenia="
				+ contrasenia + "]";
	}
	
	
	
	
	
}
