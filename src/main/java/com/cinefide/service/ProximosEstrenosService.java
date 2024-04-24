package com.cinefide.service;

import com.cinefide.domain.Cartelera;
import com.cinefide.domain.proximosEstrenos;
import java.util.List;

public interface CarteleraService {
public interface proximosEstrenosService {
    
    public List<Cartelera> getCartelera(boolean activo);
    public List<proximosEstrenos> getProximosEstrenos(boolean activo);
    
    public Cartelera getCartelera(Cartelera cartelera);
    public proximosEstrenos getProximosEstrenos(proximosEstrenos proximosEstrenos);
    
    public void save(Cartelera cartelera);
    public void save(proximosEstrenos proximosestrenos);

    public void delete (Cartelera cartelera);
    public void delete (proximosEstrenos proximosestrenos);
    
    
}