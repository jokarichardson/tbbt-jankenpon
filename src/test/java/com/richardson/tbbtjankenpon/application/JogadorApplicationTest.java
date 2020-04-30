package com.richardson.tbbtjankenpon.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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

import com.richardson.tbbtjankenpon.application.impl.JogadorApplicationImpl;
import com.richardson.tbbtjankenpon.model.Jogador;
import com.richardson.tbbtjankenpon.service.JogadorService;

@ExtendWith(MockitoExtension.class)
public class JogadorApplicationTest {

	@InjectMocks
	private JogadorApplicationImpl jogadorApplication;

	@Mock
	private JogadorService jogadorService;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@DisplayName("Testa JogadorApplication.cadastrarJogador(Jogador jogador)")
	@Test
	public void deveCadastrarJogador() {
		Jogador jogador = new Jogador("Teste");

		doNothing().when(this.jogadorService).cadastrarJogador(any());

		this.jogadorApplication.cadastrarJogador(jogador);

		verify(this.jogadorService, times(1)).cadastrarJogador(any());
	}
	
	@DisplayName("Testa JogadorApplication.removerJogador(Jogador jogador)")
	@Test
	public void deveRemoverJogadas() {
		doNothing().when(this.jogadorService).removerJogador(any());

		this.jogadorApplication.removerJogador(new Jogador("Teste"));

		verify(this.jogadorService, times(1)).removerJogador(any());
	}

	@DisplayName("Testa JogadorApplication.listarJogadores()")
	@Test
	public void deveListarJogadores() {
		List<Jogador> expectedJogadorList = new ArrayList<>();
		expectedJogadorList.add(new Jogador("Jogador 1"));
		expectedJogadorList.add(new Jogador("Jogador 2"));

		when(this.jogadorService.listarJogadores()).thenReturn(expectedJogadorList);

		List<Jogador> actualJogadorList = this.jogadorApplication.listarJogadores();

		assertNotNull(actualJogadorList);
		assertEquals(expectedJogadorList.size(), actualJogadorList.size());
		verify(this.jogadorService, times(1)).listarJogadores();
	}
}
