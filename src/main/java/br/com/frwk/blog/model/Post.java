package br.com.frwk.blog.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "POST")
public class Post implements Serializable {

	private static final long serialVersionUID = -1870587403054742885L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String texto;
	
	@OneToMany
	private List<Comentario> comentario;
	
	private Usuario usario;

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

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsario() {
		return usario;
	}

	public void setUsario(Usuario usario) {
		this.usario = usario;
	}
	
	

}
