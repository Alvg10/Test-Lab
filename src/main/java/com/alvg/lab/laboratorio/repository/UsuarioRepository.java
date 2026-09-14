package com.alvg.lab.laboratorio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvg.lab.laboratorio.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario>findByEmail(String email);
    boolean existsByEmail (String email);
} 

