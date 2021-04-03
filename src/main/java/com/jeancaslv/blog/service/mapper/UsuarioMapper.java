package com.jeancaslv.blog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jeancaslv.blog.dto.UsuarioDTO;
import com.jeancaslv.blog.model.Usuario;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {
	
	public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
	
	public abstract Usuario toUsuario(UsuarioDTO usuarioDTO);
	
	public abstract UsuarioDTO toUsuarioDTO(Usuario usuario);

}
