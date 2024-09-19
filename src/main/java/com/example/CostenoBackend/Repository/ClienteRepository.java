package com.example.CostenoBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CostenoBackend.Models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    public Cliente findByCorreo(String correo);
}
