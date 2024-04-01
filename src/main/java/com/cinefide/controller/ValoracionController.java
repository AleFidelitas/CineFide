package com.cinefide.controller;

import com.cinefide.domain.Valoracion;
import com.cinefide.service.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/valoracion")
public class ValoracionController {
    
    @Autowired
    private ValoracionService valoracionService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = valoracionService.getValoracion(false);
        model.addAttribute("valoracion", lista);
        model.addAttribute("totalValoraciones", lista.size());       
        
        var descripcion = valoracionService.getValoracion(false);
        model.addAttribute("valoracion", lista);
        
        return "/valoracion/listado";
    }
            
    
}