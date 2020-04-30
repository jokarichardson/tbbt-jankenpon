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

import com.richardson.tbbtjankenpon.model.Jogada;
import com.richardson.tbbtjankenpon.model.Jogador;
import com.richardson.tbbtjankenpon.model.escolhas.Lagarto;

@ExtendWith(MockitoExtension.class)
public class JogadaServiceTest {
	
	@InjectMocks
	private JogadaService jogadaService;

	@Mock
	private List<Jogada> jogadas;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@DisplayName("Testa JogadaService.efetuarJogada(Jogada jogada)")
	@Test
	public void deveEfetuarJogada() {
		Jogada jogada = new Jogada(new Jogador("Teste"), new Lagarto());
		
		this.jogadaService.efetuarJogada(jogada);
		
		verify(this.jogadas, times(1)).add(any());
	}
	
	@DisplayName("Testa JogadaService.listarJogadas()")
	@Test
	public void deveListarJogadas() {
		List<Jogada> actualJogadaList = this.jogadaService.listarJogadas();

		assertNotNull(actualJogadaList);
	}
	
	@DisplayName("Testa JogadaService.removerJogadas()")
	@Test
	public void deveRemoverJogadas() {		
		this.jogadaService.removerJogadas();
		
		verify(this.jogadas, times(1)).clear();
	}
}
