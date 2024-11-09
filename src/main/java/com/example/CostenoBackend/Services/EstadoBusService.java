package com.example.CostenoBackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.EstadoBus;

import com.example.CostenoBackend.Repository.EstadoBusRepository;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class EstadoBusService {

    @Autowired
    private  EstadoBusRepository estadoBusRepository;
    @PostConstruct
    @Transactional
    public void init() {
        if (estadoBusRepository.count() == 0) {
            // Inserta los valores del enum si la tabla está vacía
            estadoBusRepository.save(new EstadoBus(1, "ACTIVO"));
            estadoBusRepository.save(new EstadoBus(2, "DESACTIVO"));
        }
    }
}
