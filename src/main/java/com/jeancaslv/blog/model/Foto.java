package com.jeancaslv.blog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "FOTO")
public class Foto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4186142079458395490L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_FOTO")
	private Long id;
	
	@Column(name = "CAMINHO", nullable = false)
	private String caminho;
	
	@ManyToOne
	@NotNull
    @JoinColumn(name = "ID_ALBUM", nullable = false)
	private Album album;
	
	

}
