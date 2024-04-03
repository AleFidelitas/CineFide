package com.cinefide.controller;

import com.cinefide.service.CarteleraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String confirmacion() {

        return "/pagos/confirmacion";
    }

}
