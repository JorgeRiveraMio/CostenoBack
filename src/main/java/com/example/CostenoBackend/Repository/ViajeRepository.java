package com.example.CostenoBackend.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.CostenoBackend.Models.Viaje;

public interface ViajeRepository extends JpaRepository<Viaje, Integer> {

    @Query("SELECT v FROM Viaje v WHERE v.fechaSalida = :fechaSalida AND v.fechaLlegada = :fechaLlegada AND v.ruta.idRuta = :idRuta")
    List<Viaje> buscarViajes(@Param("fechaSalida") Date fechaSalida,
            @Param("fechaLlegada") Date fechaLlegada,
            @Param("idRuta") Long idRuta);

    @Query("SELECT v FROM Viaje v WHERE v.fechaSalida >= :fechaSalida AND v.ruta.idRuta = :idRuta ORDER BY v.fechaSalida ASC") // nuevo para mostrar todos los viajes
    List<Viaje> buscarProximosViajes(@Param("fechaSalida") Date fechaSalida,
            @Param("idRuta") Long idRuta);

}
