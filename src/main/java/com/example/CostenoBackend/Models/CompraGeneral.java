package com.example.CostenoBackend.Models;

import java.util.List;

import lombok.*;


@Data
public class CompraGeneral {
    private int cantidadBoletos;  // Lista de boletos seleccionados
    private Double precioTotal;  // Precio total
    private String descripcion;  // Descripción de la compra
    private String nombre;  // Nombre del producto o servicio

}
