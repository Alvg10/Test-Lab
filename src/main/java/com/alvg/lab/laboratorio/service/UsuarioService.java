package com.alvg.lab.laboratorio.service;

import com.alvg.lab.laboratorio.dto.usuario.UsuarioRequest;
import com.alvg.lab.laboratorio.dto.usuario.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    UsuarioResponse crear(UsuarioRequest request);

    UsuarioResponse obtenerPorId(Long id);

    List<UsuarioResponse> listar();

    void eliminar(Long id);

}