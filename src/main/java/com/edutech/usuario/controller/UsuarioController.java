package com.edutech.usuario.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.usuario.model.Usuario;
import com.edutech.usuario.service.UsuarioService;

@RestController
public class UsuarioController {
  
  @Autowired
  private UsuarioService usuarioService;

  @GetMapping("/")
  public ResponseEntity<List<Usuario>> listarUsuarios() {
      List<Usuario> usuarios = usuarioService.getUsuarios();
      if (usuarios.isEmpty()) {
          return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(usuarios);
  }

  @PostMapping("/")
  public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario){
      Usuario usu = usuarioService.saveUsuario(usuario);
      return ResponseEntity.status(HttpStatus.CREATED).body(usu);
  }

  @GetMapping("{id}")
  public ResponseEntity<Usuario> buscarUsuario(@PathVariable int id){
      try{
          Usuario usu = usuarioService.getUsuario(id);
          return ResponseEntity.ok(usu);
      }catch(Exception ex){
          return ResponseEntity.notFound().build();
      }
  }

  @PutMapping("{id}")
  public ResponseEntity<Usuario> actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
      try {
          Usuario usu = usuarioService.getUsuario(id);
          usu.setId(id);
          usu.setRut(usuario.getRut());
          usu.setNombre(usuario.getNombre());
          usu.setCorreo(usuario.getCorreo());
          usu.setContrasena(usuario.getContrasena());
          usuarioService.saveUsuario(usu);
          return ResponseEntity.ok(usu);
      } catch (Exception ex) {
          return ResponseEntity.notFound().build();
      }
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> eliminarUsuario(@PathVariable int id){
      try {
          usuarioService.deleteUsuario(id);
          return ResponseEntity.noContent().build();
      } catch (Exception ex) {
          return ResponseEntity.notFound().build();
      }
  }
}