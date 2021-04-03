package br.com.frwk.blog.controlle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.frwk.blog.dto.ComentarioDTO;
import br.com.frwk.blog.service.ComentarioService;

@RestController
@RequestMapping("comentario")
public class ComentarioController {
	
	private final Logger log = LoggerFactory.getLogger(ComentarioController.class);
	
	private ComentarioService comentarioService;
	
	public ComentarioController(ComentarioService comentarioService) {
		this.comentarioService = comentarioService;
	}
	
	@PostMapping
	public ResponseEntity<String> createComentario(@RequestBody ComentarioDTO comentarioDTO){
		comentarioService.createComentario(comentarioDTO);
		return (ResponseEntity<String>) new ResponseEntity(null).ok();
	}
	
	@DeleteMapping
	public ResponseEntity<String>deleteComentario(){
		return null;
	}
	

}
