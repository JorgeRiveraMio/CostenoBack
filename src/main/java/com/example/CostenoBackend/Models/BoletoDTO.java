package com.example.CostenoBackend.Models;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BoletoDTO {
    private Integer idBoleto;
    private Double precio;
    private Date fechaEmision;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time horaEmision;  // Cambiado a Date si planeas manejar hora en formato fecha simple

    private Integer idCliente;
    private Integer idViaje;
    private Integer idAsiento;
    private Integer idBus;
    private Integer idEstadoBoleto;

    public BoletoDTO() {
    }
    public BoletoDTO(Integer idBoleto, Double precio, Date fechaEmision, Time horaEmision, Integer idCliente,
            Integer idViaje, Integer idAsiento, Integer idBus, Integer idEstadoBoleto) {
        this.idBoleto = idBoleto;
        this.precio = precio;
        this.fechaEmision = fechaEmision;
        this.horaEmision = horaEmision;
        this.idCliente = idCliente;
        this.idViaje = idViaje;
        this.idAsiento = idAsiento;
        this.idBus = idBus;
        this.idEstadoBoleto = idEstadoBoleto;
    }
    public Integer getIdBoleto() {
        return idBoleto;
    }
    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Date getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public Time getHoraEmision() {
        return horaEmision;
    }
    public void setHoraEmision(Time horaEmision) {
        this.horaEmision = horaEmision;
    }
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public Integer getIdViaje() {
        return idViaje;
    }
    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }
    public Integer getIdAsiento() {
        return idAsiento;
    }
    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }
    public Integer getIdBus() {
        return idBus;
    }
    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }
    public Integer getIdEstadoBoleto() {
        return idEstadoBoleto;
    }
    public void setIdEstadoBoleto(Integer idEstadoBoleto) {
        this.idEstadoBoleto = idEstadoBoleto;
    }

    
}
