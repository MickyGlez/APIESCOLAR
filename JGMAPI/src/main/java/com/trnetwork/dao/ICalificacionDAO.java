package com.trnetwork.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trnetwork.entity.Alumno;
import com.trnetwork.entity.Calificacion;

public interface ICalificacionDAO extends JpaRepository<Calificacion, Long> {

	//List<Calificacion> findByMatricula(Long amatricula);
	@Query(value = "SELECT * from jgm_calificacion where amatricula = ?",
			nativeQuery = true)
	List<Alumno>findByM(Long idpath);
	


}
