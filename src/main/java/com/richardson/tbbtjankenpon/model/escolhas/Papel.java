package com.richardson.tbbtjankenpon.model.escolhas;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

@JsonSerialize
public class Papel extends Escolha implements Serializable {

	private static final long serialVersionUID = 2093073720991701634L;

	@Override
	public OpcoesEnum opcao() {
		return OpcoesEnum.PAPEL;
	}

	@Override
	protected List<OpcoesEnum> venceDe() {
		return Arrays.asList(OpcoesEnum.PEDRA, OpcoesEnum.SPOCK);
	}
}
