package com.cinefide.dao;
import com.cinefide.domain.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HorariosDao extends JpaRepository<Horarios,Long> {
    
}
