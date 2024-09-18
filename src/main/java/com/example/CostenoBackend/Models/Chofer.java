package com.example.CostenoBackend.Models;

import jakarta.persistence.*;
import java.util.*;


@Entity
@Table(name = "chofer")
@PrimaryKeyJoinColumn(name = "idPersona")
public class Chofer extends Empleado{
    
    @Column(name = "liceConducir")
    private String liceConducir;

    @Column(name = "fechaLicencia")
    private Date fechaLicencia;

    @Column(name = "estado")
    private String estado;

    //falta agregar la fk de admin
    @ManyToOne
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idPersona")
    private Administrador administrador;
}
