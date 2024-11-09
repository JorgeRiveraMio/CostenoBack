package com.example.CostenoBackend.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.CostenoBackend.Models.EstadoBoleto;
import com.example.CostenoBackend.Repository.EstadoBoletoRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class EstadoBoletoService {

    @Autowired
    private EstadoBoletoRepository estadoBoletoRepository;

    @PostConstruct
    @Transactional
    public void init() {
        if (estadoBoletoRepository.count() == 0) {
            // Inserta los valores del enum si la tabla está vacía
            estadoBoletoRepository.save(new EstadoBoleto(1, "ACTIVO"));
            estadoBoletoRepository.save(new EstadoBoleto(2, "INACTIVO"));
        }
    }

}
