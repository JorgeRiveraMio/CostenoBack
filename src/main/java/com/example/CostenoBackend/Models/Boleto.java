package com.example.CostenoBackend.Models;

import java.sql.Time;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "boleto")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idBoleto")
    private Integer idBoleto;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "fechaEmision")
    private LocalDate  fechaEmision;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(name = "horaEmision")
    private Time horaEmision;

    //fk cliente
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idPersona")
    private Cliente cliente;

    //fk viaje
    @ManyToOne
    @JoinColumn(name = "idViaje", referencedColumnName = "idViaje")
    private Viaje viaje;
    
    //fk asiento
    @ManyToOne
    @JoinColumn(name = "idAsiento", referencedColumnName = "idAsiento")
    private Asiento asiento;
    
    //fk bus
    @ManyToOne
    @JoinColumn(name = "idBus", referencedColumnName = "idBus")
    private Bus bus;

    //fk estado Boleto
    @ManyToOne
    @JoinColumn(name = "idEstadoBoleto", referencedColumnName = "idEstadoBoleto")
    private EstadoBoleto estadoBoleto;

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

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Time getHoraEmision() {
        return horaEmision;
    }

    public void setHoraEmision(Time horaEmision) {
        this.horaEmision = horaEmision;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public EstadoBoleto getEstadoBoleto() {
        return estadoBoleto;
    }

    public void setEstadoBoleto(EstadoBoleto estadoBoleto) {
        this.estadoBoleto = estadoBoleto;
    }

 
  
}
