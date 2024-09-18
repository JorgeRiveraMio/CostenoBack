package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoMetodoPago")
public class TipoMetodoPago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoMetodoPago")
    private Integer idTipoMetodoPago;

    @Column(name = "nombre")
    private String nombre;
}
