package com.alvg.lab.laboratorio.dto.usuario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class UsuarioResponse {

    private Long id;

    private String nombre;

    private String email;

    private Instant fecha_creacion;

    private Boolean activo;

}