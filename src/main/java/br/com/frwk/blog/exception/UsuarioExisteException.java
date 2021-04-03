package br.com.frwk.blog.exception;

public class UsuarioExisteException extends Exception {

	private static final long serialVersionUID = -8107535547926234097L;
	
	public UsuarioExisteException(String msg){
		super(msg);
	}

}
