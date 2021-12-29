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

import com.trnetwork.dao.IDocenteDAO;
import com.trnetwork.entity.Docente;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/docente")
public class DocenteService {

	@Autowired
	IDocenteDAO doc;
	
	@GetMapping
	public ResponseEntity<List<Docente>> getAllDocente(){
		return  new ResponseEntity<>(doc.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Docente> getDocente(@PathVariable("id") long idpath){
		System.out.println("Methodo get");
		Optional<Docente> docente = doc.findById(idpath);
		
		if (docente.isPresent()) {
			return new ResponseEntity<Docente>(doc.getById(idpath), HttpStatus.OK);
		}else {
			return new ResponseEntity<Docente>(HttpStatus.NOT_FOUND);
		}
	}
	

	@PostMapping
	public ResponseEntity<Long> setDocente(@RequestBody Docente docente_request){
		
		System.out.println("Methodo POST");
		System.out.println(docente_request);
		
		Long id = doc.save(docente_request).getMatricula();
		
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Docente> updateDocente(@PathVariable("id") long idpath, @RequestBody Docente docente_request){
		System.out.println("Methodo PUT");
		
		Optional<Docente> docente = doc.findById(idpath);
		
		if (docente.isPresent()) {
			docente_request.setMatricula(idpath);
			return new ResponseEntity<>(doc.save(docente_request), HttpStatus.OK);
		}else {
			return new ResponseEntity<Docente>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleteDocente(@PathVariable("id") long idpath){
		System.out.println("DELETE");
		
		Optional<Docente> docente = doc.findById(idpath);
		
		if (docente.isPresent()) {
			doc.deleteById(idpath);
			return new ResponseEntity<>(1, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}	
	}	
	
}


















