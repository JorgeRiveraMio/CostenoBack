package com.example.CostenoBackend.Models;

import jakarta.persistence.*;


@Entity
@Table(name="asiento")
public class Asiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idAsiento")
    private Integer idAsiento;

    @Column(name = "tipoAsiento")
    private String tipoAsiento;

    @Column(name = "numPiso")
    private int numPiso;
    
    @Column(name = "numAsiento")
    private Integer numAsiento;


    //fk de estado de asiento
    @ManyToOne
    @JoinColumn(name = "idEstadoAsiento", referencedColumnName = "idEstadoAsiento")
    private EstadoAsiento estadoAsiento;

    //fk de bus 
    @ManyToOne
    @JoinColumn(name = "idBus", referencedColumnName = "idBus")
    private Bus bus;

    public Integer getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public int getNumeroPiso() {
        return numPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numPiso = numeroPiso;
    }

    public Integer getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(Integer numAsiento) {
        this.numAsiento = numAsiento;
    }

    public EstadoAsiento getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(EstadoAsiento estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    
}
