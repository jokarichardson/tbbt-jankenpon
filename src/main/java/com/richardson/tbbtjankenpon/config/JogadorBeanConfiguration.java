package com.richardson.tbbtjankenpon.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.richardson.tbbtjankenpon.model.Jogador;

@Configuration
public class JogadorBeanConfiguration {
	
	@Bean
	public List<Jogador> jogadores() {

		List<Jogador> jogadores = new ArrayList<>();
		jogadores.add(new Jogador("Jogador 1"));
		jogadores.add(new Jogador("Jogador 2"));
		jogadores.add(new Jogador("Jogador 3"));
		jogadores.add(new Jogador("Jogador 4"));
		jogadores.add(new Jogador("Jogador 5"));
		
		return jogadores;
	}
}
