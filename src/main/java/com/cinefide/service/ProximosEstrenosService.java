package com.cinefide.service;

import com.cinefide.domain.Cartelera;
import java.util.List;

public interface CarteleraService {
    
    public List<Cartelera> getCartelera(boolean activo);
    
    public Cartelera getCartelera(Cartelera cartelera);
    
    public void save(Cartelera cartelera);

    public void delete (Cartelera cartelera);
    
    
}