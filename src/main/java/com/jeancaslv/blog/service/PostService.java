package com.jeancaslv.blog.service;

import java.time.ZonedDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jeancaslv.blog.dto.PostDTO;
import com.jeancaslv.blog.repository.PostRepository;
import com.jeancaslv.blog.service.mapper.PostMapper;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@Transactional
	public void createPost(PostDTO postDTO) {
		
		this.postRepository.save(PostMapper.INSTANCE.toPost(postDTO));
	}
	
	@Transactional
	public void deletePost(PostDTO postDTO) {
		postDTO.setDataCriacao(ZonedDateTime.now());
		this.postRepository.delete(PostMapper.INSTANCE.toPost(postDTO));
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

}
