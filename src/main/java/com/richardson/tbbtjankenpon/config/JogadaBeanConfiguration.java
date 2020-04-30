package com.richardson.tbbtjankenpon.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.richardson.tbbtjankenpon.model.Jogada;
import com.richardson.tbbtjankenpon.model.Jogador;
import com.richardson.tbbtjankenpon.model.escolhas.Lagarto;
import com.richardson.tbbtjankenpon.model.escolhas.Papel;
import com.richardson.tbbtjankenpon.model.escolhas.Pedra;

@Configuration
public class JogadaBeanConfiguration {
	
	@Autowired
	private List<Jogador> jogadores;
	
	@Bean
	public List<Jogada> jogadas() {
		
		List<Jogada> jogadas = new ArrayList<>();
		Jogada jogada1 = new Jogada(this.jogadores.get(0), new Lagarto());
		Jogada jogada2 = new Jogada(this.jogadores.get(1), new Pedra());
		Jogada jogada3 = new Jogada(this.jogadores.get(2), new Papel());
//		Jogada jogada4 = new Jogada(this.jogadores.get(3), new Tesoura());
//		Jogada jogada5 = new Jogada(this.jogadores.get(4), new Spock());
		jogadas.add(jogada1);
		jogadas.add(jogada2);
		jogadas.add(jogada3);
//		jogadas.add(jogada4);
//		jogadas.add(jogada5);
		
		return jogadas;
//		return new ArrayList<>();
	}
}
