package com.example.CostenoBackend.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.Asiento;
import com.example.CostenoBackend.Models.Bus;

import com.example.CostenoBackend.Models.EstadoAsiento;
import com.example.CostenoBackend.Models.EstadoBus;
import com.example.CostenoBackend.Repository.AsientoRepository;
import com.example.CostenoBackend.Repository.BusRepository;
import com.example.CostenoBackend.Repository.EstadoAsientoRepository;
import com.example.CostenoBackend.Repository.EstadoBusRepository;



@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private AsientoRepository asientoRepository;

    @Autowired
    private EstadoBusRepository estadoBusRepository;
    
    @Autowired
    private  EstadoAsientoRepository estadoAsientoRepository;

   
  
    public String guardar(Bus bus){
        //  Verificar si el bus ya existe por número de placa
        String msgError = "";
            if (busRepository.existsByPlaca(bus.getPlaca())) {
                msgError = "El número de placa ya se encuentra registrado";
                return msgError;
            }  
         try {
         EstadoBus estadoBus = estadoBusRepository.findById(bus.getEstadoBus().getIdEstadoBus())
                         .orElseThrow(() -> new IllegalArgumentException("EstadoBus no encontrado"));
     
            bus.setEstadoBus(estadoBus); // Asignar el estado al bus  
            busRepository.save(bus); // Guardar el bus en la base de datos
            /// Crear asientos para el bus
            List<Asiento> asientos = new ArrayList<>();
            int capacidadPiso1 = bus.getCapacidadPiso1();
            int capacidadPiso2 = bus.getCapacidadPiso2();
            int totalAsientos = capacidadPiso1 + capacidadPiso2;

            // Obtener el estado "Libre" del repositorio
            EstadoAsiento estadoLibre = estadoAsientoRepository.findByEstado("Libre")
                    .orElseThrow(() -> new IllegalArgumentException("Estado 'Libre' no encontrado"));

            for (int i = 1; i <= totalAsientos; i++) {
                Asiento asiento = new Asiento();
                asiento.setBus(bus); // Relacionar el asiento con el bus
                asiento.setNumAsiento(i);
                asiento.setEstadoAsiento(estadoLibre); // Asignar estado libre al asiento

                // Asignar el piso en función del número de asiento
                if (i <= capacidadPiso1) {
                    asiento.setNumeroPiso(1); // Primer piso
                } else {
                    asiento.setNumeroPiso(2); // Segundo piso
                }
                asientos.add(asiento);
            }
            // Guardar los asientos en la base de datos
            asientoRepository.saveAll(asientos);


         }  catch (Exception e) {
                //     // En caso de error, Spring manejará el rollback automático
                msgError = e.getMessage();
        }
        return msgError;
    }
    public String alternarEstadoBusPorId(Integer idBus) {
        String msgError = "";
    
        // Verificar si el bus existe por ID
        Bus busExistente = busRepository.findById(idBus)
                .orElse(null);
    
        if (busExistente == null) {
            msgError = "El bus con el ID " + idBus + " no se encuentra registrado.";
            return msgError;
        }
    
        try {
            // Obtener el estado actual del bus
            EstadoBus estadoActual = busExistente.getEstadoBus();
    
            // Verificar si el estado actual es "Activo" o "Inactivo"
            EstadoBus nuevoEstadoBus;
            if (estadoActual.getEstado().equalsIgnoreCase("Activo")) {
                // Cambiar a "Inactivo"
                nuevoEstadoBus = estadoBusRepository.findByEstado("Inactivo")
                        .orElseThrow(() -> new IllegalArgumentException("EstadoBus 'Inactivo' no encontrado"));
            } else if (estadoActual.getEstado().equalsIgnoreCase("Inactivo")) {
                // Cambiar a "Activo"
                nuevoEstadoBus = estadoBusRepository.findByEstado("Activo")
                        .orElseThrow(() -> new IllegalArgumentException("EstadoBus 'Activo' no encontrado"));
            } else {
                // Si el estado no es ni "Activo" ni "Inactivo", lanzar un error
                throw new IllegalArgumentException("Estado actual no es válido para alternar.");
            }
    
            // Actualizar el estado del bus
            busExistente.setEstadoBus(nuevoEstadoBus);
    
            // Guardar el bus actualizado
            busRepository.save(busExistente);
    
        } catch (Exception e) {
            // Manejo de errores, rollback automático
            msgError = e.getMessage();
        }
    
        return msgError;
    }
    

}
