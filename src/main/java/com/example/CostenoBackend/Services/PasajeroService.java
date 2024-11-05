package com.example.CostenoBackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.Pasajero;
import com.example.CostenoBackend.Repository.PasajeroRepository;

@Service
public class PasajeroService {
    @Autowired
    private PasajeroRepository pasajeroRepository;

    public List<Pasajero> listar(){
        return pasajeroRepository.findAll();
    }
    public Pasajero guardar(Pasajero pasajero){
        return pasajeroRepository.save(pasajero);
    }
    public Pasajero obtener(Integer id) {
        return pasajeroRepository.findById(id).orElse(null);
    }   
    
}
