package com.example.CostenoBackend.Models;

import java.sql.Time;

public class RutaDTO {
  private Integer distancia;
    private String duracion;
    private String estadoRuta;
    private Integer idTerminalOrigen; // En lugar de la entidad, se usa el ID
    private Integer idTerminalDestino; // En lugar de la entidad, se usa el ID
    private Integer idAdministrador; // En lugar de la entidad, se usa el ID

    // Constructor
    public RutaDTO() {}

    public RutaDTO(Integer distancia, String duracion, String estadoRuta, Integer idTerminalOrigen, Integer idTerminalDestino, Integer idAdministrador) {
        this.distancia = distancia;
        this.duracion = duracion;
        this.estadoRuta = estadoRuta;
        this.idTerminalOrigen = idTerminalOrigen;
        this.idTerminalDestino = idTerminalDestino;
        this.idAdministrador = idAdministrador;
    }

    // Getters y Setters
    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEstadoRuta() {
        return estadoRuta;
    }

    public void setEstadoRuta(String estadoRuta) {
        this.estadoRuta = estadoRuta;
    }

    public Integer getIdTerminalOrigen() {
        return idTerminalOrigen;
    }

    public void setIdTerminalOrigen(Integer idTerminalOrigen) {
        this.idTerminalOrigen = idTerminalOrigen;
    }

    public Integer getIdTerminalDestino() {
        return idTerminalDestino;
    }

    public void setIdTerminalDestino(Integer idTerminalDestino) {
        this.idTerminalDestino = idTerminalDestino;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
