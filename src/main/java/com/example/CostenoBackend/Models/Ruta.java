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
    private String duracion;

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

    
    public Ruta() {
    }
    

    public Ruta(Integer idRuta, Integer distancia, String duracion, String estadoRuta, Terminal terminalOrigen,
            Terminal terminalDestino, Administrador administrador) {
        this.idRuta = idRuta;
        this.distancia = distancia;
        this.duracion = duracion;
        this.estadoRuta = estadoRuta;
        this.terminalOrigen = terminalOrigen;
        this.terminalDestino = terminalDestino;
        this.administrador = administrador;
    }


    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEstadoRuta() {
        return estadoRuta;
    }

    public void setEstadoRuta(String estadoRuta) {
        this.estadoRuta = estadoRuta;
    }

    public Terminal getTerminalOrigen() {
        return terminalOrigen;
    }

    public void setTerminalOrigen(Terminal terminalOrigen) {
        this.terminalOrigen = terminalOrigen;
    }

    public Terminal getTerminalDestino() {
        return terminalDestino;
    }

    public void setTerminalDestino(Terminal terminalDestino) {
        this.terminalDestino = terminalDestino;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    
}
