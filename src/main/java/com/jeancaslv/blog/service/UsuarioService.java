package com.jeancaslv.blog.service;

import java.time.ZonedDateTime;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.jeancaslv.blog.dto.UsuarioDTO;
import com.jeancaslv.blog.enumeration.Role;
import com.jeancaslv.blog.exception.UsuarioExisteException;
import com.jeancaslv.blog.model.Usuario;
import com.jeancaslv.blog.repository.UsuarioRepository;
import com.jeancaslv.blog.security.JwtTokenProvider;
import com.jeancaslv.blog.service.mapper.UsuarioMapper;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	private JwtTokenProvider jwtTokenProvider;
	
	private AuthenticationManager authenticationManager;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
			
	public UsuarioService(UsuarioRepository usuarioRepository,
						  JwtTokenProvider jwtTokenProvider,
						  AuthenticationManager authenticationManager) {
		this.usuarioRepository = usuarioRepository;
		this.jwtTokenProvider = jwtTokenProvider;
		this.authenticationManager = authenticationManager;
	}
	
	public void createUsuario(UsuarioDTO usuarioDTO) throws UsuarioExisteException {
		
		validaUsuarioExistente(usuarioDTO);
		Usuario usuario = UsuarioMapper.INSTANCE.toUsuario(usuarioDTO);
		usuario.setDataCriacao(ZonedDateTime.now());
		usuario.setSenha(passwordEncoder().encode(usuarioDTO.getSenha()));
		usuario.setRoles(Arrays.asList(Role.ROLE_ADMIN));
		usuarioRepository.save(usuario);
				
	}

	private void validaUsuarioExistente(UsuarioDTO usuarioDTO) throws UsuarioExisteException {
		
	   Usuario usuario = getUsarioEmail(usuarioDTO.getEmail());
		
		if(!ObjectUtils.isEmpty(usuario)) {
			throw new UsuarioExisteException("Usuário já existe no blog!");
		}
		
	}

	public String login(UsuarioDTO usuarioDTO) throws UsuarioExisteException {
		try {
		      		
		      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha()));
		      return jwtTokenProvider.createToken(usuarioDTO.getEmail(), usuarioRepository.findByEmail(usuarioDTO.getEmail()).getRoles());
		    } catch (AuthenticationException e) {
		    	e.printStackTrace();
		    }
		return null;
		
	}
	
	private Usuario getUsarioEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	

}
