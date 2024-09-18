package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estadoBus")
public class EstadoBus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idEstadoBus")
    private Integer idEstadoBus;

    @Column(name = "estado")
    private String estado;
}
