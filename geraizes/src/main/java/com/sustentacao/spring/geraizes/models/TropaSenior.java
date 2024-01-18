package com.sustentacao.spring.geraizes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tropa_senior")
public class TropaSenior {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSenior;
	
	private String patrulha;
	
	private boolean monitor;
	
	private boolean subMonitor;

	public long getIdSenior() {
		return idSenior;
	}

	public void setIdSenior(long idSenior) {
		this.idSenior = idSenior;
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

}
