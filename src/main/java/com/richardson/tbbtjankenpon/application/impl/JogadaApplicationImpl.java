package com.richardson.tbbtjankenpon.application.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.richardson.tbbtjankenpon.application.JogadaApplication;
import com.richardson.tbbtjankenpon.model.Jogada;
import com.richardson.tbbtjankenpon.service.JogadaService;

@Component
public class JogadaApplicationImpl implements JogadaApplication {

	@Autowired
	private JogadaService jogadaService;
	
	@Override
	public void efetuarJogada(Jogada jogada) {
		this.jogadaService.efetuarJogada(jogada);

	}

	@Override
	public void removerJogadas() {
		this.jogadaService.removerJogadas();

	}

	@Override
	public List<Jogada> listarJogadas() {
		return this.jogadaService.listarJogadas();
	}

	@Override
	public String jogar() {
		return this.jogadaService.jogar();
	}

}
