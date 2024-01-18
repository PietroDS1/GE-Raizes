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

import com.sustentacao.spring.geraizes.models.TropaSenior;
import com.sustentacao.spring.geraizes.repositorys.TropaSeniorRepository;



@RestController
@RequestMapping("/senior")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TropaSeniorController {
	
	@Autowired
	private TropaSeniorRepository repository;
	
	@GetMapping
	public ResponseEntity<List<TropaSenior>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<TropaSenior> Post (@RequestBody TropaSenior tropasenior){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tropasenior));
	}
	
	@PutMapping("/{idSenior}")
	public ResponseEntity<TropaSenior> updateSenior(
	        @PathVariable long idSenior,
	        @RequestBody TropaSenior senior) {

	    Optional<TropaSenior> existingSenior = repository.findById(idSenior);

	    if (existingSenior.isPresent()) {
	        TropaSenior updatedSenior = existingSenior.get();
	        updatedSenior.setPatrulha(senior.getPatrulha());
	        updatedSenior.setMonitor(senior.isMonitor());
	        updatedSenior.setSubMonitor(senior.isSubMonitor());

	        TropaSenior savedSenior = repository.save(updatedSenior);
	        return ResponseEntity.ok(savedSenior);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}
