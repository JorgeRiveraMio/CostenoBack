package com.example.CostenoBackend.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "metodoPago")
public class MetodoPago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idMetodoPago")
    private Integer idMetodoPago;

    //fk tipo de metodo de pago
    @ManyToOne
    @JoinColumn(name = "idTipoMetodoPago", referencedColumnName = "idTipoMetodoPago")
    private TipoMetodoPago tipoMetodoPago;
}
