package com.cinefide.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas")
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPelicula")
    private Long idPelicula;

    private String imagen;
    private String fecha;
    private String horario;
    private String asiento;
    private String descripcion;

}
