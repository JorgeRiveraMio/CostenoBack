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

    @Column(name = "precio")
    private Double precio;

    @Column(name = "estadoViaje")
    private String estadoViaje;
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

    
    public Viaje() {
    }
    
    public Viaje(Integer idViaje, Date fechaSalida, Date fechaLlegada, Time horaSalida, Time horaLlegada, Double precio,
            Ruta ruta, Administrador administrador, Bus bus, Chofer chofer1, Chofer chofer2) {
        this.idViaje = idViaje;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.precio = precio;
        this.ruta = ruta;
        this.administrador = administrador;
        this.bus = bus;
        this.chofer1 = chofer1;
        this.chofer2 = chofer2;
    }

    
    

    public Integer getIdViaje() {
        return idViaje;
    }



    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Chofer getChofer1() {
        return chofer1;
    }

    public void setChofer1(Chofer chofer1) {
        this.chofer1 = chofer1;
    }

    public Chofer getChofer2() {
        return chofer2;
    }

    public void setChofer2(Chofer chofer2) {
        this.chofer2 = chofer2;
    }


    public Double getPrecio() {
        return precio;
    }


    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEstadoViaje() {
        return estadoViaje;
    }

    public void setEstadoViaje(String estadoViaje) {
        this.estadoViaje = estadoViaje;
    }

    
    
}
