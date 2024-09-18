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
}
