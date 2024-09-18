package com.example.CostenoBackend.Models;

import java.sql.Time;
import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViaje")
    private Integer idViaje;

    @Column(name = "fechaSalida")
    private Date fechaSalida;

    @Column(name = "fechaLlegada")
    private Date fechaLlegada;

    @Column(name = "horaSalida")
    private Time horaSalida;

    @Column(name = "horaLlegada")
    private Time horaLlegada;

    //fk ruta
    @ManyToOne
    @JoinColumn(name = "idRuta", referencedColumnName = "idRuta")
    private Ruta ruta;

    //fk administrador
    @ManyToOne
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idPersona")
    private Administrador administrador;

    //fk bus
    @ManyToOne
    @JoinColumn(name = "idBus", referencedColumnName = "idBus")
    private Bus bus;

    //fk chofer 1 
    @ManyToOne
    @JoinColumn(name = "idChofer1", referencedColumnName = "idPersona")
    private Chofer chofer1;

    //fk chofer 2
    @ManyToOne
    @JoinColumn(name = "idChofer2", referencedColumnName = "idPersona")
    private Chofer chofer2;
}
