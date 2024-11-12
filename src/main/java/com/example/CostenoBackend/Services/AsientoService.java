package com.example.CostenoBackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CostenoBackend.Models.Asiento;
import com.example.CostenoBackend.Models.EstadoAsiento;
import com.example.CostenoBackend.Repository.AsientoRepository;
import com.example.CostenoBackend.Repository.EstadoAsientoRepository;


@Service
public class AsientoService {
    @Autowired
    private AsientoRepository asientoRepository;

    @Autowired
    private EstadoAsientoRepository estadoAsientoRepository;

    public List< Asiento> buscarPorCodBus(Integer id) {
        return asientoRepository.findByBusIdBus(id);
    }

    @Transactional
    public void actualizarEstado(Integer idAsiento, Integer nuevoEstadoId) {
        Asiento asiento = asientoRepository.findById(idAsiento).orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
        
        // Obtén el nuevo estado según el ID proporcionado
        EstadoAsiento nuevoEstado = estadoAsientoRepository.findById(nuevoEstadoId).orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        asiento.setEstadoAsiento(nuevoEstado);
        
        asientoRepository.save(asiento);
    }
}
