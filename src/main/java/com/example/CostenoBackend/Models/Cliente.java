package com.example.CostenoBackend.Models;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona {

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "idEstadoCliente", referencedColumnName = "idEstadoCliente")
    private EstadoCliente estadoCliente;

    public Cliente() {
    }

    public Cliente(int idPersona, int numDocumento, String nombres, String apellidos, String estadoCivil,
            String direccion, String numTel, Date fechaNac, Date fechaCreacion, String correo, String password,
            EstadoCliente estadoCliente) {
        super(idPersona, numDocumento, nombres, apellidos, estadoCivil, direccion, numTel, fechaNac, fechaCreacion);
        this.correo = correo;
        this.password = password;
        this.estadoCliente = estadoCliente;
    }

    public Cliente(String correo, String password, EstadoCliente estadoCliente) {
        this.correo = correo;
        this.password = password;
        this.estadoCliente = estadoCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EstadoCliente getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(EstadoCliente estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
}

