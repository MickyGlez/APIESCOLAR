package com.trnetwork.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trnetwork.entity.Alumno;

public interface IAlumnoDAO extends JpaRepository<Alumno, Long>{

	List<Alumno> findByNombre(String nombre);
	List<Alumno> findByPaterno(String paterno);
	@Query(value = "SELECT * FROM JGM_ALUMNO A WHERE A.NOMBRE = ?  AND A.PATERNO = ?", nativeQuery = true)
	List<Alumno>findByNomPat(String nombre, String paterno);
	
	

}
