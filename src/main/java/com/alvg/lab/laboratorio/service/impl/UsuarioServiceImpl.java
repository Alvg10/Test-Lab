package com.alvg.lab.laboratorio.service.impl;

import com.alvg.lab.laboratorio.dto.usuario.UsuarioRequest;
import com.alvg.lab.laboratorio.dto.usuario.UsuarioResponse;
import com.alvg.lab.laboratorio.entity.Usuario;
import com.alvg.lab.laboratorio.mapper.UsuarioMapper;
import com.alvg.lab.laboratorio.repository.UsuarioRepository;
import com.alvg.lab.laboratorio.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponse crear(UsuarioRequest request) {

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El email ya existe");
        }

        Usuario usuario = usuarioMapper.toEntity(request);

        usuario.setFecha_creacion(Instant.now());

        if (request.getActivo() == null) {
            usuario.setActivo(true);
        } else {
            usuario.setActivo(request.getActivo());
        }

        Usuario guardado = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(guardado);
    }

    @Override
    public UsuarioResponse obtenerPorId(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public List<UsuarioResponse> listar() {

        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toResponse)
                .toList();
    }

    @Override
    public void eliminar(Long id) {

        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }

        usuarioRepository.deleteById(id);
    }
}