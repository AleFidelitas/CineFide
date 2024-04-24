package com.cinefide.controller;

import com.cinefide.domain.ReservaConfirmacion;
import com.cinefide.domain.Reservas;
import com.cinefide.domain.Usuario;
import com.cinefide.service.ReservasService;
import com.cinefide.service.CarteleraService;
import com.cinefide.service.UsuarioService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
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
    private HttpSession session;
        
    @Autowired
    private CarteleraService carteleraService;

    @Autowired
    private ReservasService reservasService;
    
        @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/pagar/{idReserva}")
    public String pagar(Reservas reservas, Model model) {
        reservas = reservasService.getReservas(reservas);
        String[] asientos = reservas.getAsiento().split("-");
        int cantBoletos = asientos.length*3200;
        model.addAttribute("cantBoletos", cantBoletos);
        model.addAttribute("reservas", reservas);

        return "/pagos/pagar";
    }

    @GetMapping("/modiftrticar/{idRrtreserva}")
    public String modifica(Reservas reservas, Model model) {
        reservas = reservasService.getReservas(reservas);
        model.addAttribute("reservas", reservas);
        return "/reservas/modifica";
    }

    @PostMapping("/confirmacion")
    public String confirmacion(ReservaConfirmacion reservasConfirmacion) throws MessagingException{
        Long idUsuario = (Long) session.getAttribute("idUsuario");
       Usuario usuario = usuarioService.findByIdUsuario(idUsuario);
        reservasService.notificar(reservasConfirmacion, usuario.getCorreo());
        return "/pagos/confirmacion";
    }

    
//        @PostMapping("/confirmacion")
//    public String confirmacion(@RequestParam("tarjeta") String tarjeta,
//            @RequestParam("numTarjeta") String numTarjeta,
//            @RequestParam("tnombPelicula") String nombPelicula,
//            @RequestParam("tasientosPelicula") String asientosPelicula,
//            @RequestParam("tcostoPelicula") String costoPelicula,
//            @RequestParam("thoraPelicula") String horaPelicula) {
//        // System.out.println("Tarjeta: " + tarjeta);
//
//        return "/pagos/confirmacion";
//    }
}
