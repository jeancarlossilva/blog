package com.jeancaslv.blog.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jeancaslv.blog.dto.PostDTO;
import com.jeancaslv.blog.model.Post;

@Mapper(componentModel = "spring")
public abstract class PostMapper {
	
	public static PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
	
	public abstract Post toPost(PostDTO postDTO);
	
	public abstract PostDTO toPostDTO(Post post);
	
	public abstract List<PostDTO> toListPostDTO(List<Post> listPost);

}
