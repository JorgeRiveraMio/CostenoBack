package com.example.CostenoBackend.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tipoDocumento")
public class TipoDocumento {
    
    @Id
    private Integer id;
    private String nombre;
}
