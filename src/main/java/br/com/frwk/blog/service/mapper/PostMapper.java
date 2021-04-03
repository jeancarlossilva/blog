package br.com.frwk.blog.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.frwk.blog.dto.PostDTO;
import br.com.frwk.blog.model.Post;

@Mapper(componentModel = "spring")
public abstract class PostMapper {
	
	public static PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
	
	public abstract Post toPost(PostDTO postDTO);
	
	public abstract PostDTO toPostDTO(Post post);
	
	public abstract List<PostDTO> toListPostDTO(List<Post> listPost);

}
