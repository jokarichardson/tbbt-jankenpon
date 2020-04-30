package com.richardson.tbbtjankenpon.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.richardson.tbbtjankenpon.model.dto.JogadaDTO;
import com.richardson.tbbtjankenpon.model.escolhas.Escolha;

@JsonSerialize
public class Jogada implements Serializable {

	private static final long serialVersionUID = -8495925687248313640L;
	
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
	
	public static JogadaDTO toJogadaDTO(Jogada jogada) {
		return new JogadaDTO(jogada.getJogador().getNome(), jogada.getOpcaoEscolhida().opcao());
	}
	
	public static Jogada fromJogadaDTO(JogadaDTO jogadaDTO) {
		Jogada jogada = new Jogada();
		jogada.setJogador(new Jogador(jogadaDTO.getJogador()));
		jogada.setOpcaoEscolhida(Escolha.fromOpcoesEnum(jogadaDTO.getEscolha()));
		
		return jogada;
	}

}
