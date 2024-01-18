package com.sustentacao.spring.geraizes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "tb_membros")
public class Membros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long membroId;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String ramo;
	
	@NotNull
	private int idade;
	
	@NotBlank
	private String sexo;

	@NotNull
	private int registro;

	public long getMembroId() {
		return membroId;
	}

	public void setMembroId(long membroId) {
		this.membroId = membroId;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
