package com.richardson.tbbtjankenpon.application;

import java.util.List;

import com.richardson.tbbtjankenpon.model.Jogada;

public interface JogadaApplication {
	void efetuarJogada(Jogada jogada);
	void removerJogadas();
	List<Jogada> listarJogadas();
	
	String jogar();
}
