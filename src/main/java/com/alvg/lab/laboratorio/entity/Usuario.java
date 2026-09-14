package com.alvg.lab.laboratorio.entity;

import java.time.Instant;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class Usuario {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",length = 100)
    private String nombre;

    @Column(name = "email",length = 150)
    private String email;

    @Column(name = "password",length = 255)
    private String password;

    @Column(name = "fecha_creacion")
    private Instant fecha_creacion;

    @Column(name = "activo")
    private boolean activo;

}
