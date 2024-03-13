package com.cinefide.controller;

import com.cinefide.domain.Promocion;
import com.cinefide.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/promocion")
public class PromocionController {
    @Autowired
    private PromocionService promocionService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = promocionService.getPromocion(false);
        model.addAttribute("promocion", lista);
        model.addAttribute("totalPromocion", lista.size());       
        return "/promocion/listado";
    }
            
            
    @GetMapping("/modificar/{idPromocion}")
    public String modifica(Promocion promocion, Model model){
        promocion = promocionService.getPromocion(promocion);
        model.addAttribute("promocion", promocion);
        return "/promocion/modifica";
    }
    
        @GetMapping("/eliminar/{idPromocion}")
    public String elimina(Promocion promocion){
        promocionService.delete(promocion);
        return "redirect:/promocion/listado";
    }}
