package com.cinefide.controller;

import com.cinefide.domain.Reservas;
import com.cinefide.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservas")
public class ReservasController {
    
    @Autowired
    private ReservasService reservasService;

    @GetMapping("/listado")
    public String listado(Model model){
        var lista = reservasService.getReservas(false);
        model.addAttribute("reservas", lista);
        model.addAttribute("totalReservas", lista.size());       
        return "/reservas/listado";
    }
            
            
    @GetMapping("/modificar/{idPelicula}")
    public String modifica(Reservas reservas, Model model){
        reservas = reservasService.getReservas(reservas);
        model.addAttribute("reservas", reservas);
        return "/reservas/modifica";
    }
    
        @GetMapping("/eliminar/{idPelicula}")
    public String elimina(Reservas reservas){
        reservasService.delete(reservas);
        return "redirect:/reservas/listado";
    }
}


