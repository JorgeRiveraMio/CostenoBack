package com.example.CostenoBackend.Models;

import java.sql.Time;
import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "boleto")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idBoleto")
    private Integer idBoleto;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "fechaEmision")
    private Date fechaEmision;

    @Column(name = "horaEmision")
    private Time horaEmision;

    //fk cliente
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idPersona")
    private Cliente cliente;

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

    //fk estado Boleto
    @ManyToOne
    @JoinColumn(name = "idEstadoBoleto", referencedColumnName = "idEstadoBoleto")
    private EstadoBoleto estadoBoleto;

  
}
