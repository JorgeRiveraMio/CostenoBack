package com.example.CostenoBackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.Viaje;
import com.example.CostenoBackend.Repository.ViajeRepository;

@Service
public class ViajeService {
    @Autowired
    private ViajeRepository viajeRepository;
      
        public List<Viaje> listar() {
            return viajeRepository.findAll();
        }
    
        
        public Viaje guardar(Viaje viaje) {
            return viajeRepository.save(viaje);
        }
    
        
        public Viaje obtener(Integer id) {
            return viajeRepository.findById(id).orElse(null);
        }
}
