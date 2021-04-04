package com.jeancaslv.blog.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jeancaslv.blog.dto.ComentarioDTO;
import com.jeancaslv.blog.exception.CustomException;
import com.jeancaslv.blog.model.Comentario;
import com.jeancaslv.blog.model.Usuario;
import com.jeancaslv.blog.repository.ComentarioRepository;
import com.jeancaslv.blog.service.mapper.ComentarioMapper;
import com.jeancaslv.blog.util.UsuarioUtil;

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
	
	
	public void deleteComentario(Long id) throws CustomException {
		
		Comentario comentario = findByIdOrException(id);
		Usuario usuario = comentario.getUsuario();
		
		String usuarioLogado = UsuarioUtil.getUsuarioLogado();
		
		if(!usuario.getEmail().equals(usuarioLogado)){
			throw new CustomException("Usuario não possui permissao para excluir. Somente o criador pode.");
		}
		
		this.comentarioRepository.delete(comentario);
		
		
	}
	
	 public Comentario findByIdOrException(Long id) throws CustomException {
	        return comentarioRepository.findById(id)
	                .orElseThrow(() -> new CustomException("Comentario não encontrado"));
	 }

	

}
