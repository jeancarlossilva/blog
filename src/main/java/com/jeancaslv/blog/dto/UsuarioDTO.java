package com.jeancaslv.blog.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = -1785226769920100087L;
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private ZonedDateTime dataCriacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ZonedDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(ZonedDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	

}
