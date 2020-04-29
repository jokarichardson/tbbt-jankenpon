package com.richardson.tbbtjankenpon.model.escolhas;

import java.util.Arrays;
import java.util.List;

import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

public class Lagarto extends Escolha {

	@Override
	public OpcoesEnum opcao() {
		return OpcoesEnum.LAGARTO;
	}

	@Override
	protected List<OpcoesEnum> venceDe() {
		return Arrays.asList(OpcoesEnum.PAPEL, OpcoesEnum.SPOCK);
	}
}
