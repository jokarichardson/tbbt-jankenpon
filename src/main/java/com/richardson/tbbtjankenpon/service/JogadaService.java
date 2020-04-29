package com.richardson.tbbtjankenpon.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richardson.tbbtjankenpon.exception.TbbtJankenponGeneralException;
import com.richardson.tbbtjankenpon.model.Jogada;

@Service
public class JogadaService {
	
	@Autowired
	private List<Jogada> jogadas;
	
	public List<Jogada> listarJogadas() {
		return this.jogadas;
	}
	
	public void removerJogadas() {
		this.jogadas.clear();
	}
	
	public void efetuarJogada(Jogada jogada) {
		try {
			
			Predicate<Jogada> filtroNomeJogador = j -> j.getJogador().getNome().equalsIgnoreCase(jogada.getJogador().getNome());
			
			if (!this.jogadas.stream().filter(filtroNomeJogador).findAny()
					.isPresent())
				this.jogadas.add(jogada);
		} catch (Exception ex) {
			throw new TbbtJankenponGeneralException(ex.getMessage());
		}
	}
}
