package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estadoAsiento")
public class EstadoAsiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idEstadoAsiento")
    private Integer idEstadoAsiento;

    @Column(name = "estado")
    private String estado;

    
    public EstadoAsiento() {
    }


    public EstadoAsiento(Integer idEstadoAsiento, String estado) {
        this.idEstadoAsiento = idEstadoAsiento;
        this.estado = estado;
    }


    public Integer getIdEstadoAsiento() {
        return idEstadoAsiento;
    }


    public void setIdEstadoAsiento(Integer idEstadoAsiento) {
        this.idEstadoAsiento = idEstadoAsiento;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
