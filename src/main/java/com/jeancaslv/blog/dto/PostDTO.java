package com.jeancaslv.blog.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

public class PostDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1991429992787500249L;
	
	private Long id;
	private String texto;
	private ZonedDateTime dataCriacao;
	private List<ComentarioDTO> comentarios;
	private UsuarioDTO usuario;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public ZonedDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(ZonedDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	

}
