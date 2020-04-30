package com.richardson.tbbtjankenpon.model.escolhas;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

@JsonSerialize
public abstract class Escolha implements Serializable {

	private static final long serialVersionUID = 1236605929884536112L;

	public abstract OpcoesEnum opcao();

	public OpcoesEnum avaliarJogada(OpcoesEnum opcaoJogada) {
		if (venceDe().contains(opcaoJogada))
			return opcao();

		return opcaoJogada;
	}

	protected abstract List<OpcoesEnum> venceDe();

	public static Escolha fromOpcoesEnum(OpcoesEnum opcaoEnum) {
		switch (opcaoEnum) {
			case TESOURA:
				return new Tesoura();
			case PAPEL:
				return new Papel();
			case PEDRA:
				return new Pedra();
			case LAGARTO:
				return new Lagarto();
			case SPOCK:
				return new Spock();
		}

		return null;
	}
}
