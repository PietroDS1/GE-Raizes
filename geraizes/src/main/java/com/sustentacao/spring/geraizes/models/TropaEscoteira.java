package com.sustentacao.spring.geraizes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tropa_escoteira")
public class TropaEscoteira{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEscoteiro;
	
	private String patrulha;
	
	private boolean monitor;
	
	private boolean subMonitor;

	private boolean tesoureiro;
	
	private boolean escriba;
	
	public long getIdEscoteiro() {
		return idEscoteiro;
	}

	public void setIdEscoteiro(long idEscoteiro) {
		this.idEscoteiro = idEscoteiro;
	}

	public String getPatrulha() {
		return patrulha;
	}

	public void setPatrulha(String patrulha) {
		this.patrulha = patrulha;
	}

	public boolean isMonitor() {
		return monitor;
	}

	public void setMonitor(boolean monitor) {
		this.monitor = monitor;
	}

	public boolean isSubMonitor() {
		return subMonitor;
	}

	public void setSubMonitor(boolean subMonitor) {
		this.subMonitor = subMonitor;
	}

	public boolean isTesoureiro() {
		return tesoureiro;
	}

	public void setTesoureiro(boolean tesoureiro) {
		this.tesoureiro = tesoureiro;
	}

	public boolean isEscriba() {
		return escriba;
	}

	public void setEscriba(boolean escriba) {
		this.escriba = escriba;
	}
}
