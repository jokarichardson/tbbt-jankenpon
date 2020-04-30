package com.richardson.tbbtjankenpon.application;

import java.util.List;

import com.richardson.tbbtjankenpon.model.dto.JogadaDTO;

public interface JogadaApplication {
	void efetuarJogada(JogadaDTO jogadaDTO);
	void removerJogadas();
	List<JogadaDTO> listarJogadas();
	
	String jogar();
}
