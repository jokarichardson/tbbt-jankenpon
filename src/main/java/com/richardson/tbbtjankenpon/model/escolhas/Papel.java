package com.richardson.tbbtjankenpon.model.escolhas;

import java.util.Arrays;
import java.util.List;

import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

public class Papel extends Escolha {

	@Override
	public OpcoesEnum opcao() {
		return OpcoesEnum.PAPEL;
	}

	@Override
	protected List<OpcoesEnum> venceDe() {
		return Arrays.asList(OpcoesEnum.PEDRA, OpcoesEnum.SPOCK);
	}
}
