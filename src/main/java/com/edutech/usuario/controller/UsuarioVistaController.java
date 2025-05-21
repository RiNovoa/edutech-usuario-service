package com.edutech.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edutech.usuario.model.Usuario;
import com.edutech.usuario.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioVistaController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String mostrarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "usuarios";
    }

    @PostMapping("/agregar")
    public String agregarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "redirect:/usuarios";
    }
}
