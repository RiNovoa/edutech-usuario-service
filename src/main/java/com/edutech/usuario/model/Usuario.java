package com.edutech.usuario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String rut;
    @Column(nullable = false, length = 8)
    private String nombre;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String contrasena;
}
