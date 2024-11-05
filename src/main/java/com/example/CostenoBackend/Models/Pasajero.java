package com.example.CostenoBackend.Models;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "pasajero")
public class Pasajero{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idPasajero")
    private Integer idPasajero;
    
    @Column(name = "numDocumento")
    private String numDocumento;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "fecNacimiento")
    private Date fecNacimiento;

    //fk boleto
    @ManyToOne
    @JoinColumn(name = "idBoleto", referencedColumnName = "idBoleto")
    private Boleto boleto;

    public Pasajero() {

    } 

    public Pasajero(Integer idPasajero, String numDocumento, String nombres, String apellidos, Date fecNacimiento,
            Boleto boleto) {
        this.idPasajero = idPasajero;
        this.numDocumento = numDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecNacimiento = fecNacimiento;
        this.boleto = boleto;
    }

    public Integer getIdPasajero() {
        return idPasajero;
    }
    public void setIdPasajero(Integer idPasajero) {
        this.idPasajero = idPasajero;
    }
    public String getNumDocumento() {
        return numDocumento;
    }
    public void setNumDocumento(String numDocumento) {
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
    public Date getFecNacimiento() {
        return fecNacimiento;
    }
    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }
    public Boleto getBoleto() {
        return boleto;
    }
    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
    
    



}
