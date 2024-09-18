package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleViaje")
public class DetalleViaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idDetalleViaje")
    private Integer idDetalleViaje;

    //fk viaje
    @ManyToOne
    @JoinColumn(name = "idViaje", referencedColumnName = "idViaje")
    private Viaje viaje;

    //fk asiento
    @ManyToOne
    @JoinColumn(name = "idAsiento", referencedColumnName = "idAsiento")
    private Asiento asiento;

    //fk bus
    @ManyToOne
    @JoinColumn(name = "idBus", referencedColumnName = "idBus")
    private Bus bus;
}
