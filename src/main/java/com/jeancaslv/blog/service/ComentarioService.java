package com.jeancaslv.blog.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.jeancaslv.blog.dto.ComentarioDTO;
import com.jeancaslv.blog.dto.PostDTO;
import com.jeancaslv.blog.exception.ComentarioNaoExiste;
import com.jeancaslv.blog.model.Comentario;
import com.jeancaslv.blog.repository.ComentarioRepository;
import com.jeancaslv.blog.service.mapper.ComentarioMapper;
import com.jeancaslv.blog.service.mapper.PostMapper;

@Service
public class ComentarioService {
	
	private ComentarioRepository comentarioRepository;
	
	public ComentarioService(ComentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;
	}
	
	@Transactional
	public void createComentario(ComentarioDTO comentarioDTO) {
		this.comentarioRepository.save(ComentarioMapper.INSTANCE.toComentario(comentarioDTO));
	}
	
	@Transactional
	public void deleteComentario(Long id) throws ComentarioNaoExiste {
		
		Comentario comentario = getComentario(id);
		
		if(ObjectUtils.isEmpty(comentario)) {
			throw new ComentarioNaoExiste("Comentario nao exite");
		}
		
		//pegar o usuairo logado
		
		
	}
	
	private Comentario getComentario(Long id) {
		return comentarioRepository.findById(id).get();
	}

	
	

}
