package com.cinefide.service;

import com.cinefide.domain.Rol;
import java.util.List;

public interface RolService {

    
    
    //trae registro por id 
    public Rol getRol(Rol rol);
    
    //si id promocion tiene un valor, se modifica ese registro
    //si idpromocion no tiene un valor se inserta un nuevo registro
    public void save(Rol roles);
    
    //se eimina el registro que tenga el valor del idpromocion que trae
    public void delete (Rol roles);
    
     public void deleteByUser(long idUsuario);
    
    
}
