package br.com.frwk.blog.controlle;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.frwk.blog.dto.UsuarioDTO;
import br.com.frwk.blog.service.UsuarioService;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	private final Logger log = LoggerFactory.getLogger(UsuarioController.class);

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping(value = "/{id}/movement")
	public ResponseEntity<UsuarioDTO> createUsuario(
			@ApiParam(value = "Id da partida a ser jogada.") @PathVariable String id,
			@ApiParam(value = "Dados da partida a ser jogada.") @RequestBody UsuarioDTO partida) {
		return null;
	}

}
