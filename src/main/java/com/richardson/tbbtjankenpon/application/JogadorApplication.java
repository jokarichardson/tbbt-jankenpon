package com.richardson.tbbtjankenpon.application;

import java.util.List;

import com.richardson.tbbtjankenpon.model.Jogador;

public interface JogadorApplication {
	void cadastrarJogador(Jogador jogador);
	void removerJogador(Jogador jogador);
	List<Jogador> listarJogadores();
}
