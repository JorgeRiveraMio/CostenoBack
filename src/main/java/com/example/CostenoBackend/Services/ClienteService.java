package com.example.CostenoBackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CostenoBackend.Models.Cliente;
import com.example.CostenoBackend.Repository.ClienteRepository;

import jakarta.persistence.Column;


@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> Listar() {
        return clienteRepository.findAll();
    }

    public Cliente Guardar(Cliente u) {
        return clienteRepository.save(u);
    }
    
    public Cliente Obtener(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente obtenerUsuario(String correo) {
        return clienteRepository.findByCorreo(correo);
    }
  
}
