package com.richardson.tbbtjankenpon.model.escolhas;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

@JsonSerialize
public class Lagarto extends Escolha implements Serializable {

	private static final long serialVersionUID = -7140452972192406421L;

	@Override
	public OpcoesEnum opcao() {
		return OpcoesEnum.LAGARTO;
	}

	@Override
	protected List<OpcoesEnum> venceDe() {
		return Arrays.asList(OpcoesEnum.PAPEL, OpcoesEnum.SPOCK);
	}
}
