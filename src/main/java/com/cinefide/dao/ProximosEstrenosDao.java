package com.cinefide.dao;

import com.cinefide.domain.Cartelera;
import com.cinefide.domain.proximosEstrenos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteleraDao extends JpaRepository<Cartelera,Long>{
public interface proximosEstrenosDao extends JpaRepository<proximosEstrenos,Long>{
    
}
