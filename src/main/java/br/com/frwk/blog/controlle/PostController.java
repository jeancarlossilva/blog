package br.com.frwk.blog.controlle;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.frwk.blog.dto.PostDTO;
import br.com.frwk.blog.service.PostService;
import br.com.frwk.blog.service.UsuarioService;

@RestController
@RequestMapping("post")
public class PostController {
	
	private final Logger log = LoggerFactory.getLogger(PostController.class);

	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@PostMapping
	public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO){
		this.postService.createPost(postDTO);
		
		return null;
	}
	
	
	@DeleteMapping
	public ResponseEntity<String>deletePost(){
		return null;
	}
	
	@PostMapping(value = "/filter")
	public ResponseEntity<Page<PostDTO>> filter(@RequestBody Pageable pageable ){
		
		return new ResponseEntity<>(postService.filter(pageable), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> getAllPosts(){
		return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
	}

}
