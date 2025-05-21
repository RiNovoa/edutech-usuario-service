package com.edutech.usuario.repository;

import java.util.*;
import org.springframework.stereotype.Repository;

import com.edutech.usuario.model.Rol;
import com.edutech.usuario.model.Usuario;

@Repository
public class UsuarioRepository {
    Rol rolAdmin = new Rol(1, "Administrador");
    private List<Usuario> listaUsuarios = new ArrayList<>(); 
    public UsuarioRepository(){
        listaUsuarios.add(new Usuario(1,"20562050-8","rishi rish","rishimadridista","15champions",rolAdmin,true));
        
    }
    public List<Usuario> obteneUsuarios(){
        return listaUsuarios;
    }
    public Usuario buscarPorId(int id){
        for (Usuario usuario : listaUsuarios){
            if(usuario.getId()==id){
                return usuario;
            }
        }
        return null;
    }

    public Usuario guardar(Usuario usu){
        listaUsuarios.add(usu);
        return usu;
    }
    public Usuario actualizar(Usuario usu){
        int id = 0;
        int idPosicion=0;
        for(int i = 0; i<listaUsuarios.size();i++){
            if(listaUsuarios.get(i).getId()==usu.getId()){
                id=usu.getId();
                idPosicion=i;
            }
        }
        Usuario usuario1 = new Usuario();
        usuario1.setId(id);
        usuario1.setRut(usu.getRut());
        usuario1.setNombre(usu.getNombre());
        usuario1.setCorreo(usu.getCorreo());
        usuario1.setContrasena(usu.getContrasena());
        listaUsuarios.set(idPosicion, usuario1);
        return usuario1;
    }
    public void eliminar (int id){
        Usuario usuario = buscarPorId(id);
        if(usuario!=null){
            listaUsuarios.remove(usuario);
        }
    }

    public int totalUsuarios(){
        return listaUsuarios.size();
    }
}
