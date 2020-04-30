package com.richardson.tbbtjankenpon.model.escolhas;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

@JsonSerialize
public class Tesoura extends Escolha implements Serializable {
	
	private static final long serialVersionUID = -3666426575651715687L;

	@Override
	public OpcoesEnum opcao() {
		return OpcoesEnum.TESOURA;
	}

	@Override
	protected List<OpcoesEnum> venceDe() {
		return Arrays.asList(OpcoesEnum.PAPEL, OpcoesEnum.LAGARTO);
	}
}
