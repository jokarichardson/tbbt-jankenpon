package com.richardson.tbbtjankenpon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richardson.tbbtjankenpon.application.JogadaApplication;
import com.richardson.tbbtjankenpon.application.JogadorApplication;
import com.richardson.tbbtjankenpon.model.Jogador;
import com.richardson.tbbtjankenpon.model.dto.JogadaDTO;
import com.richardson.tbbtjankenpon.model.response.ErrorResponseMessage;
import com.richardson.tbbtjankenpon.support.ResponseUtils;

@RestController
@RequestMapping(value = "/")
public class TbbtJankenponController {
	@Autowired
	private JogadorApplication jogadorApplication;

	@Autowired
	private JogadaApplication jogadaApplication;

	@PostMapping(value = "jogador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> cadastrarJogador(@RequestBody @Valid Jogador jogador) {
		try {
			this.jogadorApplication.cadastrarJogador(jogador);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(this.criaErrorResponseMessage(ex, "/jogador"), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "jogador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removerJogador(@RequestBody @Valid Jogador jogador) {
		try {
			this.jogadorApplication.removerJogador(jogador);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(this.criaErrorResponseMessage(ex, "/jogador"), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "jogador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listarJogadores() {
		try {
			return new ResponseEntity<>(this.jogadorApplication.listarJogadores(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(this.criaErrorResponseMessage(ex, "/jogador"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "jogada", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> efetuarJogada(@RequestBody @Valid JogadaDTO jogadaDTO) {
		try {
			this.jogadaApplication.efetuarJogada(jogadaDTO);
			;
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(this.criaErrorResponseMessage(ex, "/jogada"), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "jogada/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listarJogadas() {
		try {
			return new ResponseEntity<>(this.jogadaApplication.listarJogadas(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(this.criaErrorResponseMessage(ex, "/jogada/listar"), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "jogada", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removerJogadas() {
		try {
			this.jogadaApplication.removerJogadas();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(this.criaErrorResponseMessage(ex, "/jogada"), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "jogada", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> jogar() {
		try {
			return new ResponseEntity<>(this.jogadaApplication.jogar(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(this.criaErrorResponseMessage(ex, "/jogada"), HttpStatus.BAD_REQUEST);
		}
	}

	private ErrorResponseMessage criaErrorResponseMessage(Exception ex, String caminho) {
		return ResponseUtils.criaResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
				ex.getMessage(), ex.getClass().getSimpleName(), caminho);
	}
}
