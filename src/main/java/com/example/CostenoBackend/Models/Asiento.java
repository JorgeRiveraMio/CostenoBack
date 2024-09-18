package com.example.CostenoBackend.Models;

import jakarta.persistence.*;


@Entity
@Table(name="asiento")
public class Asiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idAsiento")
    private Integer idAsiento;

    @Column(name = "numAsiento")
    private Integer numAsiento;

    @Column(name = "tipoAsiento")
    private String tipoAsiento;

    //fk de estado de asiento
    @ManyToOne
    @JoinColumn(name = "idEstadoAsiento", referencedColumnName = "idEstadoAsiento")
    private EstadoAsiento estadoAsiento;

    //fk de bus 
    @ManyToOne
    @JoinColumn(name = "idBus", referencedColumnName = "idBus")
    private Bus bus;
}
