package com.example.CostenoBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CostenoBackend.Models.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {
     boolean existsByPlaca(String placa);
}
