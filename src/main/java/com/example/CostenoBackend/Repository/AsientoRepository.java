package com.example.CostenoBackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CostenoBackend.Models.Asiento;

public interface AsientoRepository extends JpaRepository<Asiento,Integer> {
    List<Asiento> findByBusIdBus(Integer idBus);
}
