package com.jeancaslv.blog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeancaslv.blog.dto.ComentarioDTO;
import com.jeancaslv.blog.exception.CustomException;
import com.jeancaslv.blog.service.ComentarioService;

@RestController
@RequestMapping("comentario")
public class ComentarioController {
	
	private final Logger log = LoggerFactory.getLogger(ComentarioController.class);
	
	private ComentarioService comentarioService;
	
	public ComentarioController(ComentarioService comentarioService) {
		this.comentarioService = comentarioService;
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Void> createComentario(@RequestBody ComentarioDTO comentarioDTO){
		comentarioService.createComentario(comentarioDTO);
		return  new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<String>deleteComentario(@PathVariable Long id){
		try {
			comentarioService.deleteComentario(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
		}
		
	}
	
	@GetMapping(path = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<List<ComentarioDTO>> getComentariosPost(){
		return null;
		
	}
	

}
