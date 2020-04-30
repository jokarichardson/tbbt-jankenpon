package com.richardson.tbbtjankenpon.support;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.richardson.tbbtjankenpon.model.Jogada;

public class JogoValidator {

	public Boolean validarQuantidadeJogadas(List<Jogada> jogadas) {
		if (CollectionUtils.isEmpty(jogadas) || jogadas.size() < 2)
			return Boolean.FALSE;
		
		return Boolean.TRUE;
	}
}
