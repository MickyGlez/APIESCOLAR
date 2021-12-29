package com.trnetwork.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@CrossOrigin(origins = "*")
@Table(name = "jgm_calificacion")
public class Calificacion {

	@Id
	private long id_cal;
	private long id_docmat;
	private int p1;
	private int p2;
	private int p3;
	private Double pro_cal;
	private long amatricula;
	
	public Calificacion() {		
	}
	public Calificacion(long id_cal, long id_docmat, int p1, int p2, int p3, Double pro_cal, long amatricula) {
		super();
		this.id_cal = id_cal;
		this.id_docmat = id_docmat;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.pro_cal = pro_cal;
		this.amatricula = amatricula;
	}

	public long getId_cal() {
		return id_cal;
	}

	public void setId_cal(long id_cal) {
		this.id_cal = id_cal;
	}

	public long getId_docmat() {
		return id_docmat;
	}

	public void setId_docmat(long id_docmat) {
		this.id_docmat = id_docmat;
	}

	public int getP1() {
		return p1;
	}

	public void setP1(int p1) {
		this.p1 = p1;
	}

	public int getP2() {
		return p2;
	}

	public void setP2(int p2) {
		this.p2 = p2;
	}

	public int getP3() {
		return p3;
	}

	public void setP3(int p3) {
		this.p3 = p3;
	}

	public Double getPro_cal() {
		return pro_cal;
	}

	public void setPro_cal(Double pro_cal) {
		this.pro_cal = pro_cal;
	}

	public long getAmatricula() {
		return amatricula;
	}

	public void setAmatricula(long amatricula) {
		this.amatricula = amatricula;
	}

	@Override
	public String toString() {
		return "Calificacion [id_cal=" + id_cal + ", id_docmat=" + id_docmat + ", p1=" + p1 + ", p2=" + p2 + ", p3="
				+ p3 + ", pro_cal=" + pro_cal + ", amatricula=" + amatricula + "]";
	}
	
}
