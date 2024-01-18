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

import com.sustentacao.spring.geraizes.models.Membros;
import com.sustentacao.spring.geraizes.repositorys.MembrosRepository;

@RestController
@RequestMapping("/membros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MembrosController {

	@Autowired
	private MembrosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Membros>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Membros> Post (@RequestBody Membros membros){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(membros));
	}
	
	 @PutMapping("/{membroId}")
	    public ResponseEntity<Membros> updateMembro(
	            @PathVariable long membroId,
	            @RequestBody Membros membros) {

	        Optional<Membros> existingMembro = repository.findById(membroId);

	        if (existingMembro.isPresent()) {
	            Membros updatedMembro = existingMembro.get();
	            updatedMembro.setNome(membros.getNome());
	            updatedMembro.setRegistro(membros.getRegistro());
	            updatedMembro.setRamo(membros.getRamo());
	            updatedMembro.setSexo(membros.getSexo());
	            updatedMembro.setIdade(membros.getIdade());
	            updatedMembro.setRegistro(membros.getRegistro());
	            Membros savedMembro = repository.save(updatedMembro);
	            return ResponseEntity.ok(savedMembro);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
