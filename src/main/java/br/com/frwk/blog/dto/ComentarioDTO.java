package br.com.frwk.blog.dto;

import java.io.Serializable;

public class ComentarioDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6098531562261847161L;
	
	private Long id;
	private String comentario;
	private UsuarioDTO usuario;
	private PostDTO post;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public PostDTO getPost() {
		return post;
	}
	public void setPost(PostDTO post) {
		this.post = post;
	}
	
	
	

}
