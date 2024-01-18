package com.sustentacao.spring.geraizes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sustentacao.spring.geraizes.models.TropaEscoteira;
import com.sustentacao.spring.geraizes.repositorys.TropaEscoteiraRepository;

@RestController
@RequestMapping("/escoteiro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TropaEscoteiraController {

	
	@Autowired
	private TropaEscoteiraRepository repository;
	
	@GetMapping
	public ResponseEntity<List<TropaEscoteira>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<TropaEscoteira> Post (@RequestBody TropaEscoteira tropaescoteira){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tropaescoteira));
	}
}
