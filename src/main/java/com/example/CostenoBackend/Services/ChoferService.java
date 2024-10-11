package com.example.CostenoBackend.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CostenoBackend.Models.Chofer;
import com.example.CostenoBackend.Repository.ChoferRepository;


@Service
public class ChoferService {
    @Autowired
    private ChoferRepository choferRepository;

    public List<Chofer> listar(){
        return choferRepository.findAll();
    }
    public Chofer guardar(Chofer chofer){
        return choferRepository.save(chofer);
    }
    public Chofer obtener(Integer id) {
        return choferRepository.findById(id).orElse(null);
    }

    public Chofer cambiarEstado(Integer id, boolean nuevoEstado) {
        Chofer choferExistente = choferRepository.findById(id).orElse(null);
        if (choferExistente != null) {
            choferExistente.setEstado(nuevoEstado);
            return choferRepository.save(choferExistente);
        }
        return null;
    }
    
}
