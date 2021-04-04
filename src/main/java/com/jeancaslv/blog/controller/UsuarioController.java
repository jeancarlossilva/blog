package com.jeancaslv.blog.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeancaslv.blog.dto.UsuarioDTO;
import com.jeancaslv.blog.exception.CustomException;
import com.jeancaslv.blog.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	private final Logger log = LoggerFactory.getLogger(UsuarioController.class);

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<String> createUsuario(@RequestBody UsuarioDTO usuario) {
		try {
			usuarioService.createUsuario(usuario);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (CustomException e) {
			log.error("Erro: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@RequestBody UsuarioDTO usuario) {
		try {
			return new ResponseEntity<>(usuarioService.login(usuario),HttpStatus.OK);
		} catch (CustomException e) {
			log.error("Erro: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
	}

}
