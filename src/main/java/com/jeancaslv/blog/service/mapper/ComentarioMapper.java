package com.jeancaslv.blog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jeancaslv.blog.dto.ComentarioDTO;
import com.jeancaslv.blog.model.Comentario;

@Mapper(componentModel = "spring")
public abstract class ComentarioMapper {
	
    public static ComentarioMapper INSTANCE = Mappers.getMapper(ComentarioMapper.class);
	
	public abstract Comentario toComentario(ComentarioDTO comentarioDTO);
	
	public abstract ComentarioDTO toComentarioDTO(Comentario comentario);

}
