package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estadoBoleto")
public class EstadoBoleto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idEstadoBoleto")
    private Integer idEstadoBoleto;

    @Column(name = "estado")
    private String estado;

    
    public EstadoBoleto() {
    }


    public EstadoBoleto(Integer idEstadoBoleto, String estado) {
        this.idEstadoBoleto = idEstadoBoleto;
        this.estado = estado;
    }


    public Integer getIdEstadoBoleto() {
        return idEstadoBoleto;
    }


    public void setIdEstadoBoleto(Integer idEstadoBoleto) {
        this.idEstadoBoleto = idEstadoBoleto;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
