package com.cinefide.service;

import com.cinefide.domain.Valoracion;
import java.util.List;

public interface ValoracionService {
    
    public List<Valoracion> getValoracion(boolean activo);
    
    public Valoracion getValoracion(Valoracion valoracion);
    
    public void save(Valoracion valoracion);

    public void delete (Valoracion valoracion);
    
    
}