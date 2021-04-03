package br.com.frwk.blog.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.frwk.blog.dto.UsuarioDTO;
import br.com.frwk.blog.model.Usuario;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {
	
	public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
	
	public abstract Usuario toUsuario(UsuarioDTO usuarioDTO);
	
	public abstract UsuarioDTO toUsuarioDTO(Usuario usuario);

}
