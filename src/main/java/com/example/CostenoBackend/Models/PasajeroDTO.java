package com.example.CostenoBackend.Models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class PasajeroDTO {
    private Integer idPasajero;
    private String numDocumento;
    private String nombres;
    private String apellidos;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecNacimiento;
    
    private Integer idBoleto;

    public PasajeroDTO() {
    }

    public PasajeroDTO(Integer idPasajero, String numDocumento, String nombres, String apellidos, Date fecNacimiento,
            Integer idBoleto) {
        this.idPasajero = idPasajero;
        this.numDocumento = numDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecNacimiento = fecNacimiento;
        this.idBoleto = idBoleto;
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

    public Integer getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }   

    

    
}
