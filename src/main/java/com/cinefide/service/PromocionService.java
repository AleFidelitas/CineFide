package com.cinefide.service;

import com.cinefide.domain.Promocion;
import java.util.List;

public interface PromocionService {
    
    //se define la firma del metodo para obtener los registros de promocion
    public List<Promocion> getPromocion(boolean activo);
    
    
    
    //trae registro por id 
    public Promocion getPromocion(Promocion promocion);
    
    //si id promocion tiene un valor, se modifica ese registro
    //si idpromocion no tiene un valor se inserta un nuevo registro
    public void save(Promocion promocion);
    
    //se eimina el registro que tenga el valor del idpromocion que trae
    public void delete (Promocion promocion);
    
    
}
