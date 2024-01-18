package com.sustentacao.spring.geraizes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/{idEscoteiro}")
	public ResponseEntity<TropaEscoteira> updateEscoteiro(
	        @PathVariable long idEscoteiro,
	        @RequestBody TropaEscoteira escoteira) {

	    Optional<TropaEscoteira> existingEscoteira = repository.findById(idEscoteiro);

	    if (existingEscoteira.isPresent()) {
	        TropaEscoteira updatedEscoteira = existingEscoteira.get();
	        updatedEscoteira.setPatrulha(escoteira.getPatrulha());
	        updatedEscoteira.setMonitor(escoteira.isMonitor());
	        updatedEscoteira.setSubMonitor(escoteira.isSubMonitor());
	        updatedEscoteira.setTesoureiro(escoteira.isTesoureiro());
	        updatedEscoteira.setEscriba(escoteira.isEscriba());

	        TropaEscoteira savedEscoteira = repository.save(updatedEscoteira);
	        return ResponseEntity.ok(savedEscoteira);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}
