package com.richardson.tbbtjankenpon.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

import com.richardson.tbbtjankenpon.application.impl.JogadaApplicationImpl;
import com.richardson.tbbtjankenpon.enums.OpcoesEnum;
import com.richardson.tbbtjankenpon.model.Jogada;
import com.richardson.tbbtjankenpon.model.Jogador;
import com.richardson.tbbtjankenpon.model.dto.JogadaDTO;
import com.richardson.tbbtjankenpon.model.escolhas.Lagarto;
import com.richardson.tbbtjankenpon.model.escolhas.Spock;
import com.richardson.tbbtjankenpon.service.JogadaService;
import com.richardson.tbbtjankenpon.service.JogoService;

@ExtendWith(MockitoExtension.class)
public class JogadaApplicationTest {

	@InjectMocks
	private JogadaApplicationImpl jogadaApplication;

	@Mock
	private JogadaService jogadaService;

	@Mock
	private JogoService jogoService;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@DisplayName("Testa JogadaApplication.efetuarJogada(JogadaDTO jogadaDTO)")
	@Test
	public void deveEfetuarJogada() {
		JogadaDTO jogadaDTO = new JogadaDTO("Teste", OpcoesEnum.LAGARTO);

		doNothing().when(this.jogadaService).efetuarJogada(any());

		this.jogadaApplication.efetuarJogada(jogadaDTO);

		verify(this.jogadaService, times(1)).efetuarJogada(any());
	}
	
	@DisplayName("Testa JogadaApplication.removerJogadas()")
	@Test
	public void deveRemoverJogadas() {
		doNothing().when(this.jogadaService).removerJogadas();

		this.jogadaApplication.removerJogadas();

		verify(this.jogadaService, times(1)).removerJogadas();
	}

	@DisplayName("Testa JogadaApplication.listarJogadas()")
	@Test
	public void deveListarJogadas() {
		List<Jogada> expectedJogadaList = new ArrayList<>();
		Jogada jogada1 = new Jogada(new Jogador("Teste 1"), new Lagarto());
		Jogada jogada2 = new Jogada(new Jogador("Teste 2"), new Spock());
		expectedJogadaList.add(jogada1);
		expectedJogadaList.add(jogada2);

		when(this.jogadaService.listarJogadas()).thenReturn(expectedJogadaList);

		List<JogadaDTO> actualJogadaList = this.jogadaApplication.listarJogadas();

		assertNotNull(actualJogadaList);
		assertEquals(expectedJogadaList.size(), actualJogadaList.size());
		verify(this.jogadaService, times(1)).listarJogadas();
	}
	
	@DisplayName("Testa JogadaApplication.jogar()")
	@Test
	public void deveJogar() {
		String expectedMsg = "O vencedor foi Teste 1 com a escolha LAGARTO!";

		when(this.jogoService.jogar()).thenReturn(expectedMsg);

		String actualMsg = this.jogadaApplication.jogar();

		assertNotNull(actualMsg);
		assertTrue(expectedMsg.equals(actualMsg));
		verify(this.jogoService, times(1)).jogar();
	}	
}
