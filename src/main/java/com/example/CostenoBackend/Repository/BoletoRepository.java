package com.example.CostenoBackend.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.CostenoBackend.Models.Boleto;

public interface BoletoRepository extends JpaRepository<Boleto, Integer> {
    @Query("SELECT b FROM Boleto b WHERE b.cliente.idPersona = :idCliente")
    List<Boleto> findByClienteId(@Param("idCliente") Integer idCliente);

    @Query("SELECT b FROM Boleto b JOIN b.viaje v WHERE v.fechaSalida <= :fechaHoraActual AND b.estadoBoleto.idEstadoBoleto = 1")
    List<Boleto> findBoletosVencidos(@Param("fechaHoraActual") LocalDateTime fechaHoraActual);


}
