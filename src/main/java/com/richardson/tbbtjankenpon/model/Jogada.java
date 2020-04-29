package com.richardson.tbbtjankenpon.model;

import javax.validation.constraints.NotNull;

import com.richardson.tbbtjankenpon.model.escolhas.Escolha;

public class Jogada {
	
	@NotNull
	private Jogador jogador;
	@NotNull
	private Escolha opcaoEscolhida;
	
	public Jogada() { 
		
	}
	
	public Jogada(Jogador jogador, Escolha opcaoEscolhida) {
		this.jogador = jogador;
		this.opcaoEscolhida = opcaoEscolhida;
	}
	
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public Escolha getOpcaoEscolhida() {
		return opcaoEscolhida;
	}
	public void setOpcaoEscolhida(Escolha opcaoEscolhida) {
		this.opcaoEscolhida = opcaoEscolhida;
	}
	
	

}
