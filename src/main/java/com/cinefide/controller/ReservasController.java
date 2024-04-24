package com.cinefide.controller;

import com.cinefide.domain.Cartelera;
import com.cinefide.domain.Reservas;
import com.cinefide.service.CarteleraService;
import com.cinefide.service.ReservasService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private HttpSession session;

    @Autowired
    private ReservasService reservasService;
    
        @Autowired
    private CarteleraService carteleraService;

    @GetMapping("/listado")
    public String listado(Model model) {
        // Long idUsuario = 8L;
        Long idUsuario = (Long) session.getAttribute("idUsuario");
//        System.out.println(idUsuario);
        var lista = reservasService.getReservasByIdUsuario(idUsuario);
        model.addAttribute("reservas", lista);
        model.addAttribute("totalReservas", lista.size());
        return "/reservas/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Reservas reservas) {
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        reservas.setIdUsuario(idUsuario);
//        System.out.println(reservas);
        String imagen = reservas.getImagen();
        System.out.println(reservas + "code: u3y49534");
        
        if (imagen == null || imagen.isEmpty()) {
            
            
            Cartelera cartelera = carteleraService.findByTitulo(reservas.getTitulo());
            if (cartelera != null) {
                reservas.setImagen(cartelera.getImagen());
            } else {
                reservas.setImagen("https://www.anahuac.mx/generacion-anahuac/sites/default/files/articles/SalaDeCine.jpg");
            }
            
            
            
            
        }
        String estado = reservas.getEstado();
        if (estado == null || estado.isEmpty()) {
            reservas.setEstado("pendiente");
        }
//        System.out.println(reservas);
        reservasService.save(reservas);
        return "redirect:/reservas/listado";
    }

    @GetMapping("/modificar/{idReserva}")
    public String modifica(Reservas reservas, Model model) {
        reservas = reservasService.getReservas(reservas);
        model.addAttribute("reservas", reservas);
        return "/reservas/modifica";
    }

    @GetMapping("/eliminar/{idReserva}")
    public String elimina(Reservas reservas) {
        reservasService.delete(reservas);
        return "redirect:/reservas/listado";
    }

//        @GetMapping("/eliminar/{idReserva}")
//    public String elimina(Reservas reservas) {
//        reservasService.delete(reservas);
//        return "redirect:/reservas/listado";
//    }
}
