package com.cinefide.dao;

import com.cinefide.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol,Long>{
    
    void deleteByIdUsuario(Long idUsuario);
    
}
