package com.example.CostenoBackend.Models;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name="ruta")
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRuta")
    private Integer idRuta;

    @Column(name = "distancia")
    private Integer distancia;

    @Column(name = "duracion")
    private Time duracion;

    @Column(name = "estadoRuta")
    private String estadoRuta;

    //fk terminal origen
    @ManyToOne
    @JoinColumn(name = "idTerminalOrigen", referencedColumnName = "idTerminal")
    private Terminal terminalOrigen;

    //fk terminal destino
    @ManyToOne
    @JoinColumn(name = "idTerminalDestino", referencedColumnName = "idTerminal")
    private Terminal terminalDestino;

    //fk administrador
    @ManyToOne
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idPersona")
    private Administrador administrador;
}
