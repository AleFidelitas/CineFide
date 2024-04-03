package com.cinefide.controller;

import com.cinefide.service.CarteleraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pagos")
public class PagosController {

    @Autowired
    private CarteleraService carteleraService;

    @GetMapping("/metodos")
    public String listado(Model model) {

        return "/pagos/metodos";
    }

    @PostMapping("/confirmacion")
    public String confirmacion(@RequestParam("tarjeta") String tarjeta,
                               @RequestParam("numTarjeta") String numTarjeta,
                               @RequestParam("tnombPelicula") String nombPelicula,
                               @RequestParam("tasientosPelicula") String asientosPelicula,
                               @RequestParam("tcostoPelicula") String costoPelicula,
                               @RequestParam("thoraPelicula") String horaPelicula) {
        // System.out.println("Tarjeta: " + tarjeta);

        return "/pagos/confirmacion";
    }

}
