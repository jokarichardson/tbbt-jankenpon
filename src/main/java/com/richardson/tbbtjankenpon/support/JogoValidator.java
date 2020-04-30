package com.richardson.tbbtjankenpon.support;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.richardson.tbbtjankenpon.model.Jogada;

@Component
public class JogoValidator {

	public Boolean validarQuantidadeJogadas(List<Jogada> jogadas) {
		if (CollectionUtils.isEmpty(jogadas) || jogadas.size() < 2)
			return Boolean.FALSE;
		
		return Boolean.TRUE;
	}
}
