package com.example.CostenoBackend.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "bus")
public class Bus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idBus")
    private Integer idBus;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "placa")
    private String placa;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "CapacidadPiso1", nullable = false)
    private int capacidadPiso1;

    @Column(name = "CapacidadPiso2", nullable = false)
    private int capacidadPiso2;
    
     // El campo calculado "CapacidadTotal"
     @Transient // No se mapea a la base de datos, ya que se calcula
     private int capacidadTotal;
    //falta el fk del estado bus 

    @ManyToOne
    @JoinColumn(name = "idEstadoBus", referencedColumnName = "idEstadoBus")
    private EstadoBus estadoBus;

    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadPiso1() {
        return capacidadPiso1;
    }

    public void setCapacidadPiso1(int capacidadPiso1) {
        this.capacidadPiso1 = capacidadPiso1;
    }

    public int getCapacidadPiso2() {
        return capacidadPiso2;
    }

    public void setCapacidadPiso2(int capacidadPiso2) {
        this.capacidadPiso2 = capacidadPiso2;
    }

    public int getCapacidadTotal() {
        return capacidadPiso1 + capacidadPiso2;
    }

    // public void setCapacidadTotal(int capacidadTotal) {
    //     this.capacidadTotal = capacidadTotal;
    // }

    public EstadoBus getEstadoBus() {
        return estadoBus;
    }

    public void setEstadoBus(EstadoBus estadoBus) {
        this.estadoBus = estadoBus;
    }

    public Bus() {
    }

    public Bus(Integer idBus, String nombre, String placa, String modelo, int capacidadPiso1, int capacidadPiso2,
            int capacidadTotal, EstadoBus estadoBus) {
        this.idBus = idBus;
        this.nombre = nombre;
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadPiso1 = capacidadPiso1;
        this.capacidadPiso2 = capacidadPiso2;
        this.capacidadTotal = capacidadTotal;
        this.estadoBus = estadoBus;
    }

    


}
