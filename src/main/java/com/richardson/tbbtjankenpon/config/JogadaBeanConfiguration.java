package com.richardson.tbbtjankenpon.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.richardson.tbbtjankenpon.enums.OpcoesEnum;
import com.richardson.tbbtjankenpon.model.Jogada;
import com.richardson.tbbtjankenpon.model.Jogador;

@Configuration
public class JogadaBeanConfiguration {
	
	@Autowired
	private List<Jogador> jogadores;
	
	@Bean
	public List<Jogada> jogadas() {
		List<Jogada> jogadas = new ArrayList<>();
		Jogada jogada1 = new Jogada(this.jogadores.get(0), OpcoesEnum.LAGARTO);
		Jogada jogada2 = new Jogada(this.jogadores.get(1), OpcoesEnum.PEDRA);
		Jogada jogada3 = new Jogada(this.jogadores.get(2), OpcoesEnum.PAPEL);
		Jogada jogada4 = new Jogada(this.jogadores.get(3), OpcoesEnum.TESOURA);
		Jogada jogada5 = new Jogada(this.jogadores.get(4), OpcoesEnum.SPOCK);
		jogadas.add(jogada1);
		jogadas.add(jogada2);
		jogadas.add(jogada3);
		jogadas.add(jogada4);
		jogadas.add(jogada5);
		
		return jogadas;
	}
}
