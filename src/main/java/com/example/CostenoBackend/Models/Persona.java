package com.example.CostenoBackend.Models;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)//usa para identificar que es la clase base 
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private int idPersona;

    @Column(name = "numDocumento")
    private int numDocumento;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "estadoCivil")
    private String estadoCivil;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "numTel")
    private String numTel;

    @Column(name = "fechaNac")
    private Date fechaNac;

    @Column(name = "fechaCreacion")
    private Date fechaCreacion;

    public Persona() {

    }

    public Persona(int idPersona, int numDocumento, String nombres, String apellidos, String estadoCivil,
            String direccion, String numTel, Date fechaNac, Date fechaCreacion) {
        this.idPersona = idPersona;
        this.numDocumento = numDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
        this.numTel = numTel;
        this.fechaNac = fechaNac;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
}