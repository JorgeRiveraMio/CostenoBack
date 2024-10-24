package com.example.CostenoBackend.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Models.Administrador;
import com.example.CostenoBackend.Models.Bus;
import com.example.CostenoBackend.Models.Chofer;
import com.example.CostenoBackend.Models.Ruta;
import com.example.CostenoBackend.Models.Viaje;
import com.example.CostenoBackend.Models.ViajeDTO;
import com.example.CostenoBackend.Services.ViajeService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/viaje")
@CrossOrigin("*")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @PostMapping("/registrar")
    public ResponseEntity<Map<String, String>> registrarViaje(@RequestBody ViajeDTO viajeDTO) {
        Map<String, String> response = new HashMap<>();
        try {
            Viaje viaje = new Viaje();

            viaje.setFechaSalida(viajeDTO.getFechaSalida());
            viaje.setFechaLlegada(viajeDTO.getFechaLlegada());
            viaje.setHoraSalida(viajeDTO.getHoraSalida());
            viaje.setHoraLlegada(viajeDTO.getHoraLlegada());

            Ruta ruta = new Ruta();
            ruta.setIdRuta(viajeDTO.getIdRuta());
            viaje.setRuta(ruta);

            Administrador administrador = new Administrador();
            administrador.setIdPersona(viajeDTO.getIdAdministrador());
            viaje.setAdministrador(administrador);

            Bus bus = new Bus();
            bus.setIdBus(viajeDTO.getIdBus());
            viaje.setBus(bus);

            Chofer chofer1 = new Chofer();
            chofer1.setIdPersona(viajeDTO.getIdChofer1());
            viaje.setChofer1(chofer1);

            Chofer chofer2 = new Chofer();
            chofer2.setIdPersona(viajeDTO.getIdChofer2());
            viaje.setChofer2(chofer2);

            viajeService.guardar(viaje);

            response.put("message", "Viaje registrado correctamente");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("error", "Error al registrar el viaje: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    @GetMapping("/listar")
    public List<Viaje> listar() {
        return viajeService.listar();
    }
}
