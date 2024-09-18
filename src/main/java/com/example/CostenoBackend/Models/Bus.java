package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "bus")
public class Bus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idBus")
    private Integer idBus;

    @Column(name = "placa")
    private String placa;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "asientoPiso1")
    private Integer asientoPiso1;

    @Column(name = "asientoPiso2")
    private Integer asientoPiso2;

    //falta el fk del estado bus 
    @ManyToOne
    @JoinColumn(name = "idEstadoBus", referencedColumnName = "idEstadoBus")
    private EstadoBus estadoBus;
}
