package com.example.CostenoBackend.Models;

import java.sql.Time;
import java.util.Date;

public class ViajeDTO {
     private Integer idViaje;
    private Date fechaSalida;
    private Date fechaLlegada;
    private Time horaSalida;
    private Time horaLlegada;
    private Integer idRuta;
    private Integer idAdministrador;
    private Integer idBus;
    private Integer idChofer1;
    private Integer idChofer2;

    
    public ViajeDTO() {
    }
    
    public ViajeDTO(Integer idViaje, Date fechaSalida, Date fechaLlegada, Time horaSalida, Time horaLlegada,
            Integer idRuta, Integer idAdministrador, Integer idBus, Integer idChofer1, Integer idChofer2) {
        this.idViaje = idViaje;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.idRuta = idRuta;
        this.idAdministrador = idAdministrador;
        this.idBus = idBus;
        this.idChofer1 = idChofer1;
        this.idChofer2 = idChofer2;
    }

    public Integer getIdViaje() {
        return idViaje;
    }
    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }
    public Date getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public Date getFechaLlegada() {
        return fechaLlegada;
    }
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    public Time getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }
    public Time getHoraLlegada() {
        return horaLlegada;
    }
    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    public Integer getIdRuta() {
        return idRuta;
    }
    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }
    public Integer getIdAdministrador() {
        return idAdministrador;
    }
    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
    public Integer getIdBus() {
        return idBus;
    }
    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }
    public Integer getIdChofer1() {
        return idChofer1;
    }
    public void setIdChofer1(Integer idChofer1) {
        this.idChofer1 = idChofer1;
    }
    public Integer getIdChofer2() {
        return idChofer2;
    }
    public void setIdChofer2(Integer idChofer2) {
        this.idChofer2 = idChofer2;
    }

    
}
