package com.example.CostenoBackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.CostenoBackend.Models.EstadoBoleto;

public interface EstadoBoletoRepository extends JpaRepository <EstadoBoleto, Integer> {
  Optional<EstadoBoleto> findByEstado(String estado);

}
