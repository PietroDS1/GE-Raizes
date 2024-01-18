package com.sustentacao.spring.geraizes.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sustentacao.spring.geraizes.models.Membros;

public interface MembrosRepository extends JpaRepository<Membros, Long> {
	
}
