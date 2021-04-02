package br.com.frwk.blog.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POST")
public class Comentario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2557010673017857688L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String comentario;
	
	@OneToOne//unidirecional
	private Post post;
	
	private Usuario usuario;

}
