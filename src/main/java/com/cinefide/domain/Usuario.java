package com.cinefide.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private Long idUsuario;
    private String username;
    private String nombre;
    private String apellidos;
    private String contrasena;
    private String correo;
    private String fecha;
    private Integer tipo;
}