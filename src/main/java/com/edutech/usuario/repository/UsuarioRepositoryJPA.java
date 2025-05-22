
package com.edutech.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.usuario.model.Usuario;

@Repository
public interface UsuarioRepositoryJPA extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByRut(String rut);
}