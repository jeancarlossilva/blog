package com.jeancaslv.blog.exception;

public class ComentarioNaoExiste extends Exception {

	private static final long serialVersionUID = -8107535547926234097L;
	
	public ComentarioNaoExiste(String msg){
		super(msg);
	}

}
