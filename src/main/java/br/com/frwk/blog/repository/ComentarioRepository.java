package br.com.frwk.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.frwk.blog.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>, JpaSpecificationExecutor<Comentario> {

}
