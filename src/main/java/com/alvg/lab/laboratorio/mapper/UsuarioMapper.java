package com.alvg.lab.laboratorio.mapper;

import com.alvg.lab.laboratorio.dto.usuario.UsuarioRequest;
import com.alvg.lab.laboratorio.dto.usuario.UsuarioResponse;
import com.alvg.lab.laboratorio.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fecha_creacion", ignore = true)
    Usuario toEntity(UsuarioRequest request);
    UsuarioResponse toResponse(Usuario usuario);

}