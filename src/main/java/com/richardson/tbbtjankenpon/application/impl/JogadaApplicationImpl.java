package com.richardson.tbbtjankenpon.application.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.richardson.tbbtjankenpon.application.JogadaApplication;
import com.richardson.tbbtjankenpon.model.Jogada;
import com.richardson.tbbtjankenpon.model.dto.JogadaDTO;
import com.richardson.tbbtjankenpon.service.JogadaService;
import com.richardson.tbbtjankenpon.service.JogoService;

@Component
public class JogadaApplicationImpl implements JogadaApplication {

	@Autowired
	private JogadaService jogadaService;
	
	@Autowired
	private JogoService jogoService;
	
	@Override
	public void efetuarJogada(JogadaDTO jogadaDTO) {
		this.jogadaService.efetuarJogada(Jogada.fromJogadaDTO(jogadaDTO));
	}

	@Override
	public void removerJogadas() {
		this.jogadaService.removerJogadas();

	}

	@Override
	public List<JogadaDTO> listarJogadas() {
		List<JogadaDTO> jogadaDTOList = new ArrayList<>();
		this.jogadaService.listarJogadas().forEach(jogada -> jogadaDTOList.add(Jogada.toJogadaDTO(jogada)));
		return jogadaDTOList;
	}

	@Override
	public String jogar() {
		return this.jogoService.jogar();
	}

}
