package com.richardson.tbbtjankenpon.model.dto;

import javax.validation.constraints.NotNull;

import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

public class JogadaDTO {

	@NotNull
	private String jogador;
	@NotNull
	private OpcoesEnum escolha;
	
	public JogadaDTO() {
		
	}
	
	public JogadaDTO(String jogador, OpcoesEnum escolha) {
		this.jogador = jogador;
		this.escolha = escolha;
	}
	
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	public OpcoesEnum getEscolha() {
		return escolha;
	}
	public void setEscolha(OpcoesEnum escolha) {
		this.escolha = escolha;
	}
}
