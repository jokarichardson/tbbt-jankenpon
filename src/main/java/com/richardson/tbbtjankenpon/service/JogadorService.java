package com.richardson.tbbtjankenpon.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richardson.tbbtjankenpon.exception.TbbtJankenponGeneralException;
import com.richardson.tbbtjankenpon.model.Jogador;

@Service
public class JogadorService {

	@Autowired
	List<Jogador> jogadores;

	public void cadastrarJogador(Jogador jogador) {
		try {
			Predicate<Jogador> filtro = j -> j.getNome().equalsIgnoreCase(jogador.getNome());
			if (!this.jogadores.stream().filter(filtro).findAny()
					.isPresent())
				this.jogadores.add(jogador);
		} catch (Exception ex) {
			throw new TbbtJankenponGeneralException(ex.getMessage());
		}
	}

	public List<Jogador> listarJogadores() {
		return this.jogadores;
	}

	public void removerJogador(Jogador jogador) {
		try {
			this.jogadores.removeIf(j -> j.getNome().equalsIgnoreCase(jogador.getNome()));
		} catch (Exception ex) {
			throw new TbbtJankenponGeneralException(ex.getMessage());
		}
	}
}
