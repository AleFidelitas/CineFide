package com.cinefide.controller;

import com.cinefide.domain.Horarios;
import com.cinefide.service.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/horarios")
public class HorariosController {
    
    @Autowired
    private HorariosService horariosService;

    @GetMapping("/listado")
    public String listado(Model model){
        var lista = horariosService.getHorarios(false);
        model.addAttribute("horarios", lista);
        model.addAttribute("totalHorarios", lista.size());       
        return "/horarios/listado";
    }
            
            
  
}


