package com.example.CostenoBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CostenoBackend.Models.Viaje;

public interface ViajeRepository extends JpaRepository<Viaje,Integer> {
    
}
