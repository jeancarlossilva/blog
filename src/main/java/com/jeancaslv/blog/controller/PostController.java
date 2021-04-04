package com.jeancaslv.blog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeancaslv.blog.dto.PostDTO;
import com.jeancaslv.blog.exception.CustomException;
import com.jeancaslv.blog.service.PostService;

@RestController
@RequestMapping("post")
public class PostController {
	
	private final Logger log = LoggerFactory.getLogger(PostController.class);

	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@PostMapping
	@Secured("ROLE_CLIENT")
	public ResponseEntity<Void> createPost(@RequestBody PostDTO postDTO){
		this.postService.createPost(postDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	@Secured("ROLE_CLIENT")
	public ResponseEntity<String>deletePost(@PathVariable Long id){
		try {
			postService.deletePost(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (CustomException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
		}
	
	}
	
	@PostMapping(path = "/filter")
	@Secured("ROLE_CLIENT")
	public ResponseEntity<Page<PostDTO>> filter(@RequestBody Pageable pageable ){
		
		return new ResponseEntity<>(postService.filter(pageable), HttpStatus.OK);
	}
	
	@GetMapping
	@Secured("ROLE_CLIENT")
	public ResponseEntity<List<PostDTO>> getAllPosts(){
		return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
	}

}
