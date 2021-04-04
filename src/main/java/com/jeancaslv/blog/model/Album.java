package com.jeancaslv.blog.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "ALBUM")
public class Album implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7442585319034510822L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_ALBUM")
	private Long id;
	
	@Column(name = "TITULO")
	private String titulo;
	
	@ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", nullable = false)
    @NotNull
	private Usuario usuario;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Foto> fotos;
	
	@Column(name = "DAT_CRIACAO")
	private ZonedDateTime dataCriacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public ZonedDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(ZonedDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	
	
	

}
