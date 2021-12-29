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

import com.trnetwork.dao.ICalificacionDAO;
import com.trnetwork.entity.Calificacion;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/calificacion")
public class CalificacionService {

	@Autowired
	ICalificacionDAO cal;
	
	@GetMapping
	public ResponseEntity<List<Calificacion>> getAllCalificacion(){
		
		return new ResponseEntity<>(cal.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Calificacion> getCalificacion(@PathVariable("id") long idpath){
		System.out.println("Methodo get");
		Optional<Calificacion> calificacion = cal.findById(idpath);
		
		if (calificacion.isPresent()) {
			return new ResponseEntity<Calificacion>(cal.getById(idpath), HttpStatus.OK);
		}else {
			return new ResponseEntity<Calificacion>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Long> setCalificacion(@RequestBody Calificacion calificacion_request){
		
		System.out.println("Methodo POST");
		System.out.println(calificacion_request);
		
		Long id = cal.save(calificacion_request).getId_cal();
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Calificacion> updateCalificacion(@PathVariable("id") long idpath, @RequestBody Calificacion calificacion_request){
		System.out.println("Methodo PUT");
		
		Optional<Calificacion> calificacion = cal.findById(idpath);
		
		if (calificacion.isPresent()) {
			calificacion_request.setId_cal(idpath);
			return new ResponseEntity<>(cal.save(calificacion_request), HttpStatus.OK);
		}else {
			return new ResponseEntity<Calificacion>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteCalificacion(@PathVariable("id") long idpath){
		System.out.println("DELETE");
		
		Optional<Calificacion> calificacion = cal.findById(idpath);
		
		if (calificacion.isPresent()) {
			cal.deleteById(idpath);
			return new ResponseEntity<>(1,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}	
	
}



















