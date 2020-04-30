package com.richardson.tbbtjankenpon.model.escolhas;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

@JsonSerialize
public class Pedra extends Escolha implements Serializable {

	private static final long serialVersionUID = 794000573676539431L;

	@Override
	public OpcoesEnum opcao() {
		return OpcoesEnum.PEDRA;
	}

	@Override
	protected List<OpcoesEnum> venceDe() {
		return Arrays.asList(OpcoesEnum.LAGARTO, OpcoesEnum.TESOURA);
	}
}
