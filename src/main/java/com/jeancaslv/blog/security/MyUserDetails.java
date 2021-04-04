package com.jeancaslv.blog.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jeancaslv.blog.model.Usuario;
import com.jeancaslv.blog.repository.UsuarioRepository;

@Service
public class MyUserDetails implements UserDetailsService {
	  
	  @Autowired
	  private UsuarioRepository userRepository;

	  @Override
	  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    final Usuario user = userRepository.findByEmail(email);

	    if (user == null) {
	      throw new UsernameNotFoundException("Usuario '" + email + "' nao encontrado");
	    }

	    return org.springframework.security.core.userdetails.User
	        .withUsername(email)
	        .password(user.getSenha())
	        .authorities(user.getRoles())
	        .accountExpired(false)
	        .accountLocked(false)
	        .credentialsExpired(false)
	        .disabled(false)
	        .build();
	  }
}
