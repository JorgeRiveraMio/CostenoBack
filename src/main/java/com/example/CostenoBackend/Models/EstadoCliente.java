package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_cliente")
public class EstadoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoCliente")
    private int idEstadoCliente;

    @Column(name = "estado")
    private String estado;

    public EstadoCliente() {
    }

    public EstadoCliente(int idEstadoCliente, String estado) {
        this.idEstadoCliente = idEstadoCliente;
        this.estado = estado;
    }

    public int getIdEstadoCliente() {
        return idEstadoCliente;
    }

    public void setIdEstadoCliente(int idEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}