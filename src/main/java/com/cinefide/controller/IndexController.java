package com.cinefide.controller;

import com.cinefide.domain.Cartelera;
import com.cinefide.service.CarteleraService;
import com.cinefide.service.proximosEstrenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {

    @Autowired
    private CarteleraService carteleraService;

    @Autowired
    private proximosEstrenosService proximosEstrenosService;

    @GetMapping("/")
    public String inicio(Model model) {
        var cartelera = carteleraService.getCartelera(false);
        var lista = proximosEstrenosService.getProximosEstrenos(false);
        model.addAttribute("cartelera", cartelera);
        model.addAttribute("proximosestrenos", lista);
        return "index";
    }


}
