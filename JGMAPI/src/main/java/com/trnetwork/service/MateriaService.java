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
import org.springframework.web.bind.annotation.RestController;

import com.trnetwork.dao.IMateriaDAO;
import com.trnetwork.entity.Materia;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/materia")
public class MateriaService {
	
	@Autowired
	IMateriaDAO mat;
	

	@GetMapping
	public  ResponseEntity<List<Materia>> getAllMateria(){
		return new ResponseEntity<>(mat.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Materia> getMateria(@PathVariable("id") long idpath){
		System.out.println("Methodo get");
		Optional<Materia> materia = mat.findById(idpath);
		
		if (materia.isPresent()) {
			return new ResponseEntity<Materia>(mat.getById(idpath), HttpStatus.OK);
		}else {
			return new ResponseEntity<Materia>(HttpStatus.NOT_FOUND);
		}
	}
	

	@PostMapping
	public ResponseEntity<Long> setMateria(@RequestBody Materia materia_request){
		
		System.out.println("Methodo POST");
		System.out.println(materia_request);
		
		Long id = mat.save(materia_request).getId_materia();
		
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Materia> updateMateria(@PathVariable("id") long idpath, @RequestBody Materia materia_request){
		System.out.println("Methodo PUT");
		
		Optional<Materia> materia = mat.findById(idpath);
		
		if (materia.isPresent()) {
			materia_request.setId_materia(idpath);
			return new ResponseEntity<>(mat.save(materia_request), HttpStatus.OK);
		}else {
			return new ResponseEntity<Materia>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteMateria(@PathVariable("id") long idpath){
		System.out.println("DELETE");
		
		Optional<Materia> materia = mat.findById(idpath);
		
		if (materia.isPresent()) {
			mat.deleteById(idpath);
			return new ResponseEntity<>(1, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}	
	

	
}
