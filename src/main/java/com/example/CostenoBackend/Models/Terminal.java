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

    
    public Terminal() {
    }
    

    public Terminal(Integer idTerminal, String nombre, String direccion, String departamento, String provincia,
            String distrito, String coordenadaLatitud, String coordenadaLongitud) {
        this.idTerminal = idTerminal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.coordenadaLatitud = coordenadaLatitud;
        this.coordenadaLongitud = coordenadaLongitud;
    }


    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCoordenadaLatitud() {
        return coordenadaLatitud;
    }

    public void setCoordenadaLatitud(String coordenadaLatitud) {
        this.coordenadaLatitud = coordenadaLatitud;
    }

    public String getCoordenadaLongitud() {
        return coordenadaLongitud;
    }

    public void setCoordenadaLongitud(String coordenadaLongitud) {
        this.coordenadaLongitud = coordenadaLongitud;
    }

    
}
