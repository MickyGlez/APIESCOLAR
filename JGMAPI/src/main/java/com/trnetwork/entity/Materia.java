package com.trnetwork.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@CrossOrigin(origins = "*")
@Table(name = "jgm_materia")
public class Materia {
	
	@Id
	private long id_materia;
	private String nombre;
	
	public Materia() {
		
	}

	public Materia(long id_materia, String nombre) {
		super();
		this.id_materia = id_materia;
		this.nombre = nombre;
	}

	public long getId_materia() {
		return id_materia;
	}

	public void setId_materia(long id_materia) {
		this.id_materia = id_materia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Materia [id_materia=" + id_materia + ", nombre=" + nombre + "]";
	}
	

}
