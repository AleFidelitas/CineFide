package com.cinefide.dao;

import com.cinefide.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
