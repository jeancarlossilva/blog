package br.com.frwk.blog.service;

import org.springframework.stereotype.Service;

import br.com.frwk.blog.dto.UsuarioDTO;
import br.com.frwk.blog.model.Usuario;
import br.com.frwk.blog.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario createUsuario(UsuarioDTO usuario) {
		
		
		return null;
		
	}

}
