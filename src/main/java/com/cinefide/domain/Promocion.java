package com.cinefide.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="promocion")
public class Promocion implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPromocion")
    private Long idPromocion;
  
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
}
