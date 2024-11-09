package com.example.CostenoBackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.EstadoAsiento;

import com.example.CostenoBackend.Repository.EstadoAsientoRepository;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class EstadoAsientoService {

        @Autowired
    private  EstadoAsientoRepository estadoAsientoRepository;
    @PostConstruct
    @Transactional
    public void init() {
        if (estadoAsientoRepository.count() == 0) {
            // Inserta los valores del enum si la tabla está vacía
            estadoAsientoRepository.save(new EstadoAsiento(1, "LIBRE"));
            estadoAsientoRepository.save(new EstadoAsiento(2, "OCUPADO"));
        }
    }
}
