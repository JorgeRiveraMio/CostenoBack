package com.example.CostenoBackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CostenoBackend.Models.Administrador;
import com.example.CostenoBackend.Repository.AdministradorRepository;

@Service
public class AdministradorService {
    
    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> Listar() {
        return administradorRepository.findAll();
    }

    public Administrador Guardar(Administrador u) {
        return administradorRepository.save(u);
    }
    
    public Administrador Obtener(Integer id) {
        return administradorRepository.findById(id).orElse(null);
    }

    public Administrador obtenerUsuario(String correo) {
        return administradorRepository.findByCorreo(correo);
    }
}
