package com.richardson.tbbtjankenpon.model;

import javax.validation.constraints.NotNull;

public class Jogador {
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
