package com.example.CostenoBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CostenoBackend.Models.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
    public Administrador findByCorreo(String correo);
}
