package com.klinika.pregled.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klinika.pregled.model.Simptom;
import com.klinika.pregled.repository.SimptomRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/simptom")
public class SimptomController {

	@Autowired
	private SimptomRepository simptomRepo;
	
	@GetMapping
	public ResponseEntity<?> allSimptomi(){
		
		List<Simptom> simptomi = simptomRepo.findAll();
		return new ResponseEntity<List<Simptom>>(simptomi, HttpStatus.OK);
	}
}
