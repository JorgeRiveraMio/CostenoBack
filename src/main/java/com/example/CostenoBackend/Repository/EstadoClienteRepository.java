package com.example.CostenoBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CostenoBackend.Models.EstadoCliente;


public interface EstadoClienteRepository extends JpaRepository<EstadoCliente, Integer> {

}
