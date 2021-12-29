package com.trnetwork.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trnetwork.dao.IAlumnoDAO;
import com.trnetwork.entity.Alumno;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/alumno")
public class AlumnoService {

	@Autowired
	IAlumnoDAO alu;
	
	@GetMapping 
	public ResponseEntity<List<Alumno>> getAllAlumn(
			@RequestParam(required = false)String nombre,
			@RequestParam(required = false)String paterno
			){
		if (nombre!=null ) {
			return new ResponseEntity<>(alu.findByNombre(nombre), HttpStatus.OK);
		}
		return new ResponseEntity<>(alu.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumno(@PathVariable("id") long idpath){
		System.out.println("Methodo get");
		Optional<Alumno> alumno = alu.findById(idpath);
		
		if (alumno.isPresent()) {
			return new ResponseEntity<Alumno>(alu.getById(idpath), HttpStatus.OK);
		}else {
			return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Long> setAlumno(@RequestBody Alumno alumno_request){
		
		System.out.println("Methodo POST");
		System.out.println(alumno_request);
		
		Long id = alu.save(alumno_request).getMatricula();
		
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable("id") long idpath, @RequestBody Alumno alumno_request){
		System.out.println("Methodo PUT");
		
		Optional<Alumno> alumnoOptional = alu.findById(idpath);
		
		if (alumnoOptional.isPresent()) {
			alumno_request.setMatricula(idpath);
			return new ResponseEntity<>(alu.save(alumno_request), HttpStatus.OK);
		}else {
			return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteAlumno(@PathVariable("id") long idpath){
		System.out.println("DELETE");
		
		Optional<Alumno> alumnoOptional = alu.findById(idpath);
		
		if (alumnoOptional.isPresent()) {
			alu.deleteById(idpath);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}	
	
}
