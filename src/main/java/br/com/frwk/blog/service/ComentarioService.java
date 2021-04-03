package br.com.frwk.blog.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.frwk.blog.dto.ComentarioDTO;
import br.com.frwk.blog.dto.PostDTO;
import br.com.frwk.blog.repository.ComentarioRepository;
import br.com.frwk.blog.service.mapper.ComentarioMapper;
import br.com.frwk.blog.service.mapper.PostMapper;

@Service
public class ComentarioService {
	
	private ComentarioRepository comentarioRepository;
	
	public ComentarioService(ComentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;
	}
	
	public void createComentario(ComentarioDTO comentarioDTO) {
		this.comentarioRepository.save(ComentarioMapper.INSTANCE.toComentario(comentarioDTO));
	}
	
	@Transactional
	public void deleteComentario(ComentarioDTO comentarioDTO) {
		//aplicar regra
		this.comentarioRepository.delete(ComentarioMapper.INSTANCE.toComentario(comentarioDTO));
	}

	
	

}
