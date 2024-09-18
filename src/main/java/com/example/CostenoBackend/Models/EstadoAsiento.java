package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estadoAsiento")
public class EstadoAsiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idEstadoAsiento")
    private Integer idEstadoAsiento;

    @Column(name = "estado")
    private String estado;
}
