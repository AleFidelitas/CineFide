package com.cinefide.dao;

import com.cinefide.domain.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValoracionDao extends JpaRepository<Valoracion,Long>{
    
}
