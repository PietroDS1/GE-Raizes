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

import com.sustentacao.spring.geraizes.models.Chefia;
import com.sustentacao.spring.geraizes.repositorys.ChefiaRepository;

@RestController
@RequestMapping("/chefia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChefiaController {

	@Autowired
	private ChefiaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Chefia>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Chefia> Post (@RequestBody Chefia chefia){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(chefia));
	}
	
	@PutMapping("/{chefiaId}")
    public ResponseEntity<Chefia> updateChefe(
            @PathVariable long chefiaId,
            @RequestBody Chefia chefe) {

        Optional<Chefia> existingChefe = repository.findById(chefiaId);

        if (existingChefe.isPresent()) {
            Chefia updatedChefe = existingChefe.get();
            updatedChefe.setNomeChefe(chefe.getNomeChefe());
            updatedChefe.setRegistroChefe(chefe.getRegistroChefe());
            updatedChefe.setRamo(chefe.getRamo());
            Chefia savedChefe = repository.save(updatedChefe);
            return ResponseEntity.ok(savedChefe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
