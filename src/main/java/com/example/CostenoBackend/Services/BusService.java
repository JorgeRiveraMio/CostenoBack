package com.example.CostenoBackend.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.Asiento;
import com.example.CostenoBackend.Models.Bus;
import com.example.CostenoBackend.Models.EstadoBus;
import com.example.CostenoBackend.Repository.AsientoRepository;
import com.example.CostenoBackend.Repository.BusRepository;
import com.example.CostenoBackend.Repository.EstadoBusRepository;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private AsientoRepository asientoRepository;

    @Autowired
    private EstadoBusRepository estadoBusRepository;

    public List<Bus> listar() {
        return busRepository.findAll();
    }

    public Bus obtener(Integer id) {
        return busRepository.findById(id).orElse(null);
    }

    public ResponseEntity<?> guardar(Bus bus) {
        Map<String, String> errorResponse = new HashMap<>();

        // Validación de entrada
        if (bus.getPlaca() == null || bus.getCapacidadPiso1() < 0 || bus.getCapacidadPiso2() < 0) {
            errorResponse.put("message", "Datos inválidos para el bus");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // Comprobación de placa existente
        if (busRepository.existsByPlaca(bus.getPlaca())) {
            errorResponse.put("message", "El número de placa ya se encuentra registrado");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        try {
            // Obtener el estado del bus
            EstadoBus estadoBus = estadoBusRepository.findById(bus.getEstadoBus().getIdEstadoBus())
                    .orElseThrow(() -> new IllegalArgumentException("EstadoBus no encontrado"));
            bus.setEstadoBus(estadoBus);
            busRepository.save(bus);

            // Crear asientos
            List<Asiento> asientos = new ArrayList<>();
            int capacidadPiso1 = bus.getCapacidadPiso1();
            int capacidadPiso2 = bus.getCapacidadPiso2();
            int totalAsientos = capacidadPiso1 + capacidadPiso2;

            for (int i = 1; i <= totalAsientos; i++) {
                Asiento asiento = new Asiento();
                asiento.setBus(bus);
                asiento.setNumAsiento(i);
                asiento.setEstadoAsiento(null);
                asiento.setNumeroPiso(i <= capacidadPiso1 ? 1 : 2);
                asientos.add(asiento);
            }
            asientoRepository.saveAll(asientos);

        } catch (Exception e) {
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
        
        Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("message", "Bus registrado con éxito");
        successResponse.put("idBus", bus.getIdBus()); 
        return ResponseEntity.ok(successResponse);
    }

    public ResponseEntity<?> alternarEstadoBusPorId(Integer idBus) {
        Map<String, String> errorResponse = new HashMap<>();

        Bus busExistente = busRepository.findById(idBus).orElse(null);

        if (busExistente == null) {
            errorResponse.put("message", "El bus con el ID " + idBus + " no se encuentra registrado.");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        try {
            EstadoBus estadoActual = busExistente.getEstadoBus();
            EstadoBus nuevoEstadoBus;

            // Alternar estado sin buscar "Inactivo" o "Activo"
            nuevoEstadoBus = (estadoActual.getEstado().equalsIgnoreCase("Activo")) ? 
                estadoBusRepository.findByEstado("Inactivo").orElse(null) :
                estadoBusRepository.findByEstado("Activo").orElse(null);
            
            if (nuevoEstadoBus == null) {
                throw new IllegalArgumentException("EstadoBus no encontrado para alternar.");
            }

            busExistente.setEstadoBus(nuevoEstadoBus);
            busRepository.save(busExistente);

        } catch (Exception e) {
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // Respuesta exitosa en formato JSON
        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("message", "Estado del bus actualizado con éxito");
        return ResponseEntity.ok(successResponse);
    }
}
