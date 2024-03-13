package com.cinefide.controller;

import com.cinefide.domain.Cartelera;
import com.cinefide.service.CarteleraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cartelera")
public class CarteleraController {
    
    @Autowired
    private CarteleraService carteleraService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = carteleraService.getCartelera(false);
        model.addAttribute("cartelera", lista);
        model.addAttribute("totalCarteleras", lista.size());       
        
        var descripcion = carteleraService.getCartelera(false);
        model.addAttribute("cartelera", lista);
        
        return "/cartelera/listado";
    }
            
    
}