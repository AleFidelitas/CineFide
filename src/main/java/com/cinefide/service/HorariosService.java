package com.cinefide.service;

import com.cinefide.domain.Horarios;
import java.util.List;

public interface HorariosService {
    
   //se define la firma del metodo para obtener los registros de promocion
    public List<Horarios> getHorarios(boolean activo);
    
    
    
    //trae registro por id 
    public Horarios getHorarios(Horarios horarios);
    
    //si id promocion tiene un valor, se modifica ese registro
    //si idpromocion no tiene un valor se inserta un nuevo registro
    public void save(Horarios horarios);
    
    //se eimina el registro que tenga el valor del idpromocion que trae
    public void delete (Horarios horarios);
    
    
}
