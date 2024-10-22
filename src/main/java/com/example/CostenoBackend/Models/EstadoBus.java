package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estadoBus")
public class EstadoBus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idEstadoBus")
    private Integer idEstadoBus;

    @Column(name = "estado")
    private String estado;

    public Integer getIdEstadoBus() {
        return idEstadoBus;
    }

    public void setIdEstadoBus(Integer idEstadoBus) {
        this.idEstadoBus = idEstadoBus;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
