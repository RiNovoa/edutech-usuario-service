package com.edutech.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.usuario.model.Usuario;
import com.edutech.usuario.repository.UsuarioRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepositoryJPA usuarioRepository;

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuario(int id) throws Exception {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new Exception("Usuario no encontrado con id " + id));
    }

    public String deleteUsuario(int id){
        usuarioRepository.deleteById(id);
        return "Usuario eliminado";
    }
}
