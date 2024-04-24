package com.cinefide.service;

import com.cinefide.domain.ReservaConfirmacion;
import com.cinefide.domain.Reservas;
import com.cinefide.domain.Usuario;
import jakarta.mail.MessagingException;
import java.util.List;

public interface ReservasService {

    //se define la firma del metodo para obtener los registros de reservas
    public List<Reservas> getReservas(boolean activo);

    //trae registro por id 
    public Reservas getReservas(Reservas reservas);
    
    public List<Reservas> getReservasByIdUsuario(Long IdUsuario);

    //si id promocion tiene un valor, se modifica ese registro
    //si idpromocion no tiene un valor se inserta un nuevo registro
    public void save(Reservas reservas);

    //se eimina el registro que tenga el valor del idpromocion que trae
    public void delete(Reservas reservas);
    
    //actiañlizar estado
    public void updateEstado(Long reservaId, String nuevoEstado);
    
//     public void notificar(String costoPelicula);

    public void notificar(ReservaConfirmacion reservasConfirmacion)throws MessagingException;
}
