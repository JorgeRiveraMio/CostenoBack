package com.example.CostenoBackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.Ruta;
import com.example.CostenoBackend.Repository.RutaRepository;

@Service
public class RutaService {
    @Autowired
    private RutaRepository rutaRepository;
      
        public List<Ruta> listar() {
            return rutaRepository.findAll();
        }
    
        
        public Ruta guardar(Ruta ruta) {
            return rutaRepository.save(ruta);
        }
    
        
        public Ruta obtener(Integer id) {
            return rutaRepository.findById(id).orElse(null);
        }
}
