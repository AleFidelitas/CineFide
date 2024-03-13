package com.cinefide.dao;

import com.cinefide.domain.Cartelera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteleraDao extends JpaRepository<Cartelera,Long>{
    
}
