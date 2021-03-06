package com.richardson.tbbtjankenpon.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.richardson.tbbtjankenpon.enums.OpcoesEnum;
import com.richardson.tbbtjankenpon.exception.TbbtJankenponGeneralException;
import com.richardson.tbbtjankenpon.model.Jogada;
import com.richardson.tbbtjankenpon.support.JogoValidator;
import com.richardson.tbbtjankenpon.support.MessageUtils;

@Service
public class JogoService {

	@Autowired
	private List<Jogada> jogadas;

	@Autowired
	private JogoValidator jogoValidator;
	
	@Autowired
	private MessageUtils messageUtils;
	
	public JogoService() {
		if (CollectionUtils.isEmpty(this.jogadas)) {
			this.jogadas = new ArrayList<>();
		}
	}
	
	public String jogar() {
		if (!jogoValidator.validarQuantidadeJogadas(this.jogadas))
			throw new TbbtJankenponGeneralException(this.messageUtils.get("msg.jogadores.insuficientes"));

		return this.realizarPartida();
	}

	private String realizarPartida() {
		Jogada jogadaVencedora = new Jogada();

		if (this.avaliarEmpateInicial())
			return this.mensagemRetorno(Boolean.TRUE, jogadaVencedora);

		for (Jogada jogada : this.jogadas) {
			for (Jogada contraJogada : this.jogadas) {
				if (jogada.getJogador().getNome().equalsIgnoreCase(contraJogada.getJogador().getNome())) {
					continue;
				}

				OpcoesEnum retorno = this.avaliarOpcoes(jogada, contraJogada);

				if (retorno.equals(jogada.getOpcaoEscolhida().opcao())) {
					if (Objects.nonNull(jogadaVencedora.getJogador())) {
						retorno = this.avaliarOpcoes(jogadaVencedora, jogada);

						if (retorno.equals(jogada.getOpcaoEscolhida().opcao())) {
							jogadaVencedora = jogada;
						}
					} else {
						jogadaVencedora = jogada;
					}
				} else {
					if (Objects.nonNull(jogadaVencedora.getJogador())) {
						retorno = this.avaliarOpcoes(jogadaVencedora, contraJogada);

						if (retorno.equals(contraJogada.getOpcaoEscolhida().opcao())) {
							jogadaVencedora = contraJogada;
						}
					} else {
						jogadaVencedora = contraJogada;
					}
				}
			}
		}

		return this.mensagemRetorno(Boolean.FALSE, jogadaVencedora);
	}

	private OpcoesEnum avaliarOpcoes(Jogada jogada, Jogada contraJogada) {
		return jogada.getOpcaoEscolhida().avaliarJogada(contraJogada.getOpcaoEscolhida().opcao());
	}

	private Boolean avaliarEmpateInicial() {
		Set<OpcoesEnum> setEscolhas = new HashSet<>();
		jogadas.forEach(jogada -> setEscolhas.add(jogada.getOpcaoEscolhida().opcao()));

		if (setEscolhas.size() == 1 || setEscolhas.size() == 5)
			return Boolean.TRUE;

		return Boolean.FALSE;
	}

	private String mensagemRetorno(Boolean empate, Jogada jogadaVencedora) {
		if (empate)
			return this.messageUtils.get("msg.jogada.empate");
		else
			return MessageFormat.format(this.messageUtils.get("msg.jogada.vencedora"),
					jogadaVencedora.getJogador().getNome(), jogadaVencedora.getOpcaoEscolhida().opcao());
	}
}
