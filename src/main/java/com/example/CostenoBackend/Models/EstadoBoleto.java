package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estadoBoleto")
public class EstadoBoleto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idEstadoBoleto")
    private Integer idEstadoBoleto;

    @Column(name = "estado")
    private String estado;
}
