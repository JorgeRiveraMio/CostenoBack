package com.example.CostenoBackend.Models;

import java.util.*;
import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name="comprobante")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idComprobante")
    private Integer idComprobante;

    @Column(name= "numComprobante")
    private Integer numComprobante;

    @Column(name= "serieComprobante")
    private String serieComprobante;  

    @Column(name= "fechaEmision")
    private Date fechaEmision; 

    @Column(name= "horaEmision")
    private Time horaEmision;    

    @Column(name= "montoTotal")
    private Double montoTotal;

    //fk tipo comprobante
    @ManyToOne
    @JoinColumn(name = "idTipoComprobante", referencedColumnName = "idTipoComprobante")
    private TipoComprobante tipoComprobante;

    //fk cliente
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idPersona")
    private Cliente cliente;

    //fk metodo pago
    @ManyToOne
    @JoinColumn(name = "idMetodoPago", referencedColumnName = "idMetodoPago")
    private MetodoPago metodoPago;

    //fk estado comprobante
    @ManyToOne
    @JoinColumn(name = "idEstadoComprobante", referencedColumnName = "idEstadoComprobante")
    private EstadoComprobante estadoComprobante;

      //fk comprobante
      @ManyToOne
    @JoinColumn(name = "idBoleto", referencedColumnName = "idBoleto")
    private Boleto boleto; 
}
