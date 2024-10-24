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

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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

    public ResponseEntity<?> guardar(@RequestBody Bus bus) {
        Map<String, String> errorResponse = new HashMap<>();
    
        if (bus.getPlaca() == null || bus.getCapacidadPiso1() < 0 || bus.getCapacidadPiso2() < 0) {
            errorResponse.put("message", "Datos inválidos para el bus");
            return ResponseEntity.badRequest().body(errorResponse); 
        }
    
        if (busRepository.existsByPlaca(bus.getPlaca())) {
            errorResponse.put("message", "El número de placa ya se encuentra registrado");
            return ResponseEntity.badRequest().body(errorResponse); 
        }
    
        try {
            EstadoBus estadoBus = estadoBusRepository.findById(bus.getEstadoBus().getIdEstadoBus())
                    .orElseThrow(() -> new IllegalArgumentException("EstadoBus no encontrado"));
            bus.setEstadoBus(estadoBus);        
            Bus savedBus = busRepository.save(bus); 
    
            List<Asiento> asientos = new ArrayList<>();
            int capacidadPiso1 = savedBus.getCapacidadPiso1();
            int capacidadPiso2 = savedBus.getCapacidadPiso2();
            int totalAsientos = capacidadPiso1 + capacidadPiso2;
    
            for (int i = 1; i <= totalAsientos; i++) {
                Asiento asiento = new Asiento();
                asiento.setBus(savedBus); 
                asiento.setNumAsiento(i);
                asiento.setEstadoAsiento(null); 
                asiento.setNumeroPiso(i <= capacidadPiso1 ? 1 : 2);
                asientos.add(asiento);
            }
            asientoRepository.saveAll(asientos);
            
            Map<String, String> response = new HashMap<>();
            response.put("message", "Bus registrado correctamente");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse); 
        }
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

        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("message", "Estado del bus actualizado con éxito");
        return ResponseEntity.ok(successResponse);
    }
}

