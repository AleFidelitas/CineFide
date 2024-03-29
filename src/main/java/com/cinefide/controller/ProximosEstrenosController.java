package com.cinefide.controller;

import com.cinefide.domain.proximosEstrenos;
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
@RequestMapping("/proximosestrenos")
public class ProximosEstrenosController {
    
    @Autowired
    private proximosEstrenosService proximosEstrenosService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = proximosEstrenosService.getProximosEstrenos(false);
        model.addAttribute("proximosestrenos", lista);
        model.addAttribute("totalProximosEstrenos", lista.size());       
        
        var descripcion = proximosEstrenosService.getProximosEstrenos(false);
        model.addAttribute("proximosestrenos", lista);
        
        return "/proximosestrenos/listado";
    }
            
    
}