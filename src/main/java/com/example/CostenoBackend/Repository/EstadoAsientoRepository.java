package com.example.CostenoBackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CostenoBackend.Models.EstadoAsiento;

public interface EstadoAsientoRepository extends JpaRepository<EstadoAsiento,Integer> {
    Optional<EstadoAsiento> findByEstado(String estado);
}
