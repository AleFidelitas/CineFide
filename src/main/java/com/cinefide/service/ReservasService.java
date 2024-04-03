package com.cinefide.service;

import com.cinefide.domain.Reservas;
import com.cinefide.domain.Usuario;
import java.util.List;

public interface ReservasService {

    //se define la firma del metodo para obtener los registros de reservas
    public List<Reservas> getReservas(boolean activo);

    //trae registro por id 
    public Reservas getReservas(Reservas reservas);

    //si id promocion tiene un valor, se modifica ese registro
    //si idpromocion no tiene un valor se inserta un nuevo registro
    public void save(Reservas reservas);

    //se eimina el registro que tenga el valor del idpromocion que trae
    public void delete(Reservas reservas);
    
//     public void notificar(String costoPelicula);

//    public void notificar(String costoPelicula, String asientosPelicula, String nombPelicula, String numTarjeta, String tarjeta, String horaPelicula, Usuario usuario);
}
