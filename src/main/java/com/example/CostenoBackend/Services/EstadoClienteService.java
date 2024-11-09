package com.example.CostenoBackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.EstadoCliente;
import com.example.CostenoBackend.Repository.EstadoClienteRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class EstadoClienteService {
@Autowired
    private EstadoClienteRepository estadoClienteRepository;

    @PostConstruct
    @Transactional
    public void init() {
        if (estadoClienteRepository.count() == 0) {
            // Inserta los valores del enum si la tabla está vacía
            estadoClienteRepository.save(new EstadoCliente(1, "ACTIVO"));
            estadoClienteRepository.save(new EstadoCliente(2, "DESACTIVO"));
        }
    }

}
