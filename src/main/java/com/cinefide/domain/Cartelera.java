package com.cinefide.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="cartelera")
public class Cartelera implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPelicula")
    private Long idPelicula;
  
    private String titulo;
    private String imagen;
    private String descripcion;
    private String horario;
    
}