package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name="administrador")
@PrimaryKeyJoinColumn(name = "idPersona")
public class Administrador extends Empleado{

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String password;

    @Column(name = "estado")
    private String estado;
}
