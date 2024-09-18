package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoComprobante")
public class TipoComprobante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoComprobante")
    private Integer idTipoComprobante;

    @Column(name = "nombre")
    private String nombre;
}
