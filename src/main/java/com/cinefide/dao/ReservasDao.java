package com.cinefide.dao;
import com.cinefide.domain.Reservas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservasDao extends JpaRepository<Reservas,Long> {
    
    List<Reservas> findByIdUsuario(Long idUsuario);
}
