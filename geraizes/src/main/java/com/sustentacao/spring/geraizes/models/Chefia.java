package com.sustentacao.spring.geraizes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_chefia")
public class Chefia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idChefia;
	
	private boolean possuiCurso;
	
	private String nomeChefe;
	
	private String ramo;

	private int registroChefe;
	
	public long getIdChefia() {
		return idChefia;
	}

	public void setIdChefia(long idChefia) {
		this.idChefia = idChefia;
	}

	public boolean isPossuiCurso() {
		return possuiCurso;
	}

	public void setPossuiCurso(boolean possuiCurso) {
		this.possuiCurso = possuiCurso;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	
	public String getNomeChefe() {
		return nomeChefe;
	}

	public void setNomeChefe(String nomeChefe) {
		this.nomeChefe = nomeChefe;
	}

	public int getRegistroChefe() {
		return registroChefe;
	}

	public void setRegistroChefe(int registroChefe) {
		this.registroChefe = registroChefe;
	}

}
