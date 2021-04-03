package br.com.frwk.blog.service;

import java.time.ZonedDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.frwk.blog.dto.UsuarioDTO;
import br.com.frwk.blog.exception.UsuarioExisteException;
import br.com.frwk.blog.model.Usuario;
import br.com.frwk.blog.repository.UsuarioRepository;
import br.com.frwk.blog.service.mapper.UsuarioMapper;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
			
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public void createUsuario(UsuarioDTO usuarioDTO) throws UsuarioExisteException {
		
		validaUsuarioExistente(usuarioDTO);
		Usuario usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioDTO);
		usuario.setDataCriacao(ZonedDateTime.now());
		usuario.setSenha(passwordEncoder().encode(usuarioDTO.getSenha()));
		usuarioRepository.save(usuario);
				
	}

	private void validaUsuarioExistente(UsuarioDTO usuarioDTO) throws UsuarioExisteException {
		
	   Usuario usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		
		if(!ObjectUtils.isEmpty(usuario)) {
			throw new UsuarioExisteException("Usuário já existe no blog!");
		}
		
	}
	

}
