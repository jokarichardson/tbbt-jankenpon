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
		jogadores.add(new Jogador("George"));
		jogadores.add(new Jogador("Arthur"));
		jogadores.add(new Jogador("Mara"));
//		jogadores.add(new Jogador("Iso"));
//		jogadores.add(new Jogador("Jorge"));
		
		return jogadores;
//		return new ArrayList<>();
	}
}
