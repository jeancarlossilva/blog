package br.com.frwk.blog.controlle;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.frwk.blog.dto.UsuarioDTO;
import br.com.frwk.blog.exception.UsuarioExisteException;
import br.com.frwk.blog.service.UsuarioService;

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
		} catch (UsuarioExisteException e) {
			log.error("Erro: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
	}

}
