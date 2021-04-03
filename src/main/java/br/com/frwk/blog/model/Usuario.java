package br.com.frwk.blog.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = -2589646307024420390L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_USUARIO")
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	
	@Column(name  = "SENHA", nullable = false)
	private String senha;
	
    @Column(name = "DAT_CRIACAO")
    private ZonedDateTime dataCriacao;
    
    @OneToMany(mappedBy = "usuario")
    private List<Post> posts;

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
