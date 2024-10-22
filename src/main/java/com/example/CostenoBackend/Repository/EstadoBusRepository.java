package com.example.CostenoBackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.CostenoBackend.Models.EstadoBus;

public interface EstadoBusRepository extends JpaRepository<EstadoBus,Integer>{
    Optional<EstadoBus> findByEstado(String estado); // Definir el método
}
