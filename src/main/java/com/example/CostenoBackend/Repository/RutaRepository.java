package com.example.CostenoBackend.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.CostenoBackend.Models.Ruta;

public interface RutaRepository extends JpaRepository<Ruta,Integer>{
     @Query("SELECT r FROM Ruta r WHERE r.terminalOrigen.nombre = :nombreOrigen AND r.terminalDestino.nombre = :nombreDestino")
  Ruta buscarRutaPorTerminales(@Param("nombreOrigen") String nombreOrigen, @Param("nombreDestino") String nombreDestino);
}
