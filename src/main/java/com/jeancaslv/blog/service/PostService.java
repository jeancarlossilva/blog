package com.jeancaslv.blog.service;

import java.time.ZonedDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeancaslv.blog.dto.PostDTO;
import com.jeancaslv.blog.exception.CustomException;
import com.jeancaslv.blog.model.Post;
import com.jeancaslv.blog.model.Usuario;
import com.jeancaslv.blog.repository.PostRepository;
import com.jeancaslv.blog.service.mapper.PostMapper;
import com.jeancaslv.blog.util.UsuarioUtil;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@Transactional
	public void createPost(PostDTO postDTO) {
		postDTO.setDataCriacao(ZonedDateTime.now());
		
		this.postRepository.save(PostMapper.INSTANCE.toPost(postDTO));
	}
	
	public void deletePost(Long id) throws CustomException {
		
		Post post = findByIdOrException(id);
		Usuario usuario = post.getUsuario();
		
		String usuarioLogado = UsuarioUtil.getUsuarioLogado();
		
		if(!usuario.getEmail().equals(usuarioLogado)){
			throw new CustomException("Usuario não possui permissao para excluir. Somente o criador pode.");
		}
		
		this.postRepository.delete(post);
		
		
	}
	
	public Page<PostDTO> filter(Pageable pageable){
		
		Page<PostDTO> page = this.postRepository
				.findAll(pageable)
				.map(post -> PostMapper.INSTANCE.toPostDTO(post));
		
		return page;
	}

	public List<PostDTO> getAllPosts() {
		
		return PostMapper.INSTANCE.toListPostDTO(postRepository.findAll());
	}
	
    public Post findByIdOrException(Long id) throws CustomException {
        return postRepository.findById(id)
                .orElseThrow(() -> new CustomException("Post não encontrado"));
    }

}
