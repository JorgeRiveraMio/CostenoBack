package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estadoComprobante")
public class EstadoComprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idEstadoComprobante")
    private Integer idEstadoComprobante;

    @Column(name = "estado")
    private String estado;

}
