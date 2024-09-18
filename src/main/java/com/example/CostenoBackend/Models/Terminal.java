package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name="terminal")
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTerminal")
    private Integer idTerminal;

    @Column(name="nombre")
    private String nombre;

    @Column(name="direccion")
    private String direccion;

    @Column(name="departamento")
    private String departamento;

    @Column(name="provincia")
    private String provincia;

    @Column(name="distrito")
    private String distrito;

    @Column(name="coordenadaLatitud")
    private String coordenadaLatitud;

    @Column(name="coordenadaLongitud")
    private String coordenadaLongitud;

}
