package com.example.CostenoBackend.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chofer")
@PrimaryKeyJoinColumn(name = "idPersona")
public class Chofer extends Empleado {

    @Column(name = "licenciaConducir")
    private String licenciaConducir;

    @Column(name = "fechaLicencia")
    private Date fechaLicencia;

    @Column(name = "estado") 
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idPersona")
    private Administrador administrador;

    public Chofer() {
    }

    public Chofer(String licenciaConducir, Date fechaLicencia, boolean estado, Administrador administrador) {
        this.licenciaConducir = licenciaConducir;
        this.fechaLicencia = fechaLicencia;
        this.estado = estado;
        this.administrador = administrador;
    }
    public String getLicenciaConducir() {
        return licenciaConducir;
    }
    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }
    public Date getFechaLicencia() {
        return fechaLicencia;
    }
    public void setFechaLicencia(Date fechaLicencia) {
        this.fechaLicencia = fechaLicencia;
    }
    public boolean isEstado() { 
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado; 
    }
    public Administrador getAdministrador() {
        return administrador;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
