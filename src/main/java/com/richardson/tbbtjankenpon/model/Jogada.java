package com.richardson.tbbtjankenpon.model;

import javax.validation.constraints.NotNull;

import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

public class Jogada {
	
	@NotNull
	private Jogador jogador;
	@NotNull
	private OpcoesEnum opcao;
	
	public Jogada() { 
		
	}
	
	public Jogada(Jogador jogador, OpcoesEnum opcaoJogada) {
		this.jogador = jogador;
		this.opcao = opcaoJogada;
	}
	
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public OpcoesEnum getOpcao() {
		return opcao;
	}
	public void setOpcao(OpcoesEnum opcao) {
		this.opcao = opcao;
	}
	
	

}
