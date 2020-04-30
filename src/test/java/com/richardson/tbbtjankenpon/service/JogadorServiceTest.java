package com.richardson.tbbtjankenpon.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import com.richardson.tbbtjankenpon.model.Jogador;

@ExtendWith(MockitoExtension.class)
public class JogadorServiceTest {

	@InjectMocks
	private JogadorService jogadorService;

	@Mock
	private List<Jogador> jogadores;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@DisplayName("Testa JogadorService.cadastrarJogador(Jogador jogador)")
	@Test
	public void deveCadastrarJogador() {		
		this.jogadorService.cadastrarJogador(new Jogador("Teste"));
		
		verify(this.jogadores, times(1)).add(any());
	}
	
	@DisplayName("Testa JogadorService.listarJogadores()")
	@Test
	public void deveListarJogadores() {	
		List<Jogador> actualJogadorList = this.jogadorService.listarJogadores();
		
		assertNotNull(actualJogadorList);
		
	}
	
	@DisplayName("Testa JogadorService.removerJogador(Jogador jogador()")
	@Test
	public void deveRemoverJogador() {
		this.jogadorService.removerJogador(new Jogador("Teste"));
		
		verify(this.jogadores, times(1)).removeIf(any());
	}
}
