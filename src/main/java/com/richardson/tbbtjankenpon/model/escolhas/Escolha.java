package com.richardson.tbbtjankenpon.model.escolhas;

import java.util.List;

import com.richardson.tbbtjankenpon.enums.OpcoesEnum;

public abstract class Escolha {
	
	public abstract OpcoesEnum opcao();
	
	public OpcoesEnum avaliarJogada(OpcoesEnum opcaoJogada) {
		if (venceDe().contains(opcaoJogada))
			return opcao();
		
		 return opcaoJogada;
	}
	
	protected abstract List<OpcoesEnum> venceDe();
	
}
