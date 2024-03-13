package com.cinefide.controller;

import com.cinefide.domain.Usuario;
import com.cinefide.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/iniciar")
    public String iniciar(Model model) {
        return "/usuario/iniciar";
    }

    @PostMapping("/iniciarSesion")
    public String iniciarSesion(Usuario usuario) {
        Usuario usuarioBD = usuarioService.getByUsername(usuario.getUsername());

        if (usuarioBD != null) {
            if (usuario.getContrasena().equals(usuarioBD.getContrasena())) {
                return "redirect:/usuario/listado";
            }
            return "redirect:/usuario/iniciar?errorPass";
        } else {
            return "redirect:/usuario/iniciar?errorUs";
        }
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        return "/usuario/crear";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario) {
        // System.out.println(usuario);
        usuarioService.save(usuario);
        return "redirect:/usuario/listado";// si no esta logueado hay que hacer que redirija a loguearse
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = usuarioService.getUsuario(false);
        model.addAttribute("usuarios", lista);
        model.addAttribute("totalUsuarios", lista.size());
        return "/usuario/listado";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String elimina(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String modifica(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        System.out.println(usuario);
        return "/usuario/modifica";
    }

}
