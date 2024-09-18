package com.example.CostenoBackend.Models;

import java.util.Date;
import jakarta.persistence.*;


@Entity
@Table(name = "empleado")
@PrimaryKeyJoinColumn(name = "idPersona")
public class Empleado extends Persona{
    
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;
}
