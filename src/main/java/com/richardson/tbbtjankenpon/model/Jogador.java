package com.richardson.tbbtjankenpon.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Jogador implements Serializable {
	private static final long serialVersionUID = 6827780842322935158L;
	
	@NotNull
	private String nome;
	
	public Jogador() {
		
	}
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

}
