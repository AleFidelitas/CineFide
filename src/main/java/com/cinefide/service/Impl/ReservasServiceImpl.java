package com.cinefide.service.Impl;

import com.cinefide.dao.ReservasDao;
import com.cinefide.domain.Reservas;
import com.cinefide.service.CorreoService;
import com.cinefide.service.ReservasService;
import com.cinefide.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservasServiceImpl implements ReservasService {

    @Autowired
    private CorreoService correoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MessageSource messageSource;  //creado en semana 4...

    @Autowired
    private ReservasDao reservasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reservas> getReservas(boolean activo) {
        var lista = reservasDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Reservas getReservas(Reservas reservas) {
        return reservasDao.findById(reservas.getIdReserva()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reservas reservas) {
        reservasDao.save(reservas);
    }

    @Override
    @Transactional
    public void delete(Reservas reservas) {
        reservasDao.delete(reservas);
    }

//        private void notificar(String costoPelicula, String asientosPelicula, String nombPelicula, String numTarjeta, String tarjeta, String horaPelicula, Usuario usuario) throws MessagingException {
//    private void notificar(String costoPelicula)
//            throws MessagingException {
//
//        String mensaje = "Prueba correo" + costoPelicula;
//        String asunto = "Confirmacion de compra";
//        correoService.enviarCorreoHtml("r.alejimenez@gmail.com", asunto, mensaje);
//    }

//        public void activar(Usuario usuario) {
//        var codigo = new BCryptPasswordEncoder();
//        usuario.setPassword(codigo.encode(usuario.getPassword()));
//        usuarioService.save(usuario, true);
//    }
//    

    @Override
    public List<Reservas> getReservasByIdUsuario(Long IdUsuario) {
        var lista = reservasDao.findByIdUsuario(IdUsuario);
        return lista;
    }

}
