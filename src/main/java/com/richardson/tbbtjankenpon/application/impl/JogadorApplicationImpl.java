package com.richardson.tbbtjankenpon.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.richardson.tbbtjankenpon.application.JogadorApplication;
import com.richardson.tbbtjankenpon.model.Jogador;
import com.richardson.tbbtjankenpon.service.JogadorService;

@Component
public class JogadorApplicationImpl implements JogadorApplication {

	@Autowired
	private JogadorService jogadorService; 
	
	@Override
	public void cadastrarJogador(Jogador jogador) {
		this.jogadorService.cadastrarJogador(jogador);
	}

	@Override
	public void removerJogador(Jogador jogador) {
		this.jogadorService.removerJogador(jogador);
		
	}

	@Override
	public List<Jogador> listarJogadores() {
		return this.jogadorService.listarJogadores();
	}
}
