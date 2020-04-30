package com.richardson.tbbtjankenpon.model.escolhas;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

@JsonSerialize
public class Spock extends Escolha implements Serializable {

	private static final long serialVersionUID = -794768036639715895L;

	@Override
	public OpcoesEnum opcao() {
		return OpcoesEnum.SPOCK;
	}

	@Override
	protected List<OpcoesEnum> venceDe() {
		return Arrays.asList(OpcoesEnum.TESOURA, OpcoesEnum.PEDRA);
	}
}
