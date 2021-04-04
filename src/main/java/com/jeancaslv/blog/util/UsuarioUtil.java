package com.jeancaslv.blog.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioUtil {
	
	public static String getUsuarioLogado() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return principal instanceof UserDetails ? ((UserDetails)principal).getUsername() : principal.toString() ;
	}

}
