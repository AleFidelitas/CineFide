package com.cinefide.dao;
import com.cinefide.domain.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservasDao extends JpaRepository<Reservas,Long> {
    
}
