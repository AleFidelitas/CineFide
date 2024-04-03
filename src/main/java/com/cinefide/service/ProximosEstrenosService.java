package com.cinefide.service;

import com.cinefide.domain.proximosEstrenos;
import java.util.List;

public interface proximosEstrenosService {
    
    public List<proximosEstrenos> getProximosEstrenos(boolean activo);
    
    public proximosEstrenos getProximosEstrenos(proximosEstrenos proximosEstrenos);
    
    public void save(proximosEstrenos proximosestrenos);

    public void delete (proximosEstrenos proximosestrenos);
    
    
}