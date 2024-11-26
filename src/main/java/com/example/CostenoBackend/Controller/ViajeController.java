package com.example.CostenoBackend.Controller;


import java.util.Date;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Models.Administrador;
import com.example.CostenoBackend.Models.Bus;
import com.example.CostenoBackend.Models.Chofer;
import com.example.CostenoBackend.Models.Ruta;
import com.example.CostenoBackend.Models.Viaje;
import com.example.CostenoBackend.Models.ViajeDTO;
import com.example.CostenoBackend.Services.ViajeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
            viaje.setPrecio(viajeDTO.getPrecio());
            viaje.setEstadoViaje(viajeDTO.getEstadoViaje());

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


    @GetMapping("/buscar")
    public List<Viaje> buscarViajes(
            @RequestParam("fechaSalida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaSalida,
            @RequestParam("fechaLlegada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaLlegada,
            @RequestParam("idRuta") Long idRuta) {        
        return viajeService.buscarViajes(fechaSalida, fechaLlegada, idRuta);
    }

    @GetMapping("/buscarProximos")  // nuevo para mostrar todos los viajes proximos
    public List<Viaje> buscarProximosViajes(
            @RequestParam("fechaSalida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaSalida,
            @RequestParam("idRuta") Long idRuta) {
        return viajeService.buscarProximosViajes(fechaSalida, idRuta);
    }


 
    @GetMapping("/buscar/{id}")
    public Viaje buscarPorId(@PathVariable Integer id) {
        return this.viajeService.obtener(id);
    }
      @PutMapping(path = "actualizarEstado/{id}")
    public ResponseEntity<Object> actualizarEstado(@PathVariable Integer id) {
        String mensaje;
        Viaje actual = this.viajeService.obtener(id);
    
        if (actual != null) {
            if (actual.getEstadoViaje().equals("activo")) {  // Comparación correcta con equals()
                actual.setEstadoViaje("inactivo");
                mensaje = "El estado pasó a inactivo";
            } else {
                actual.setEstadoViaje("activo");
                mensaje = "El estado pasó a activo";
            }
    
            this.viajeService.guardar(actual);  // Guardar el estado actualizado
        } else {
            mensaje = "El estado no se actualizó correctamente";  // Mensaje de error
        }
    
        // Crear un mapa para la respuesta
        Map<String, String> response = new HashMap<>();
        response.put("message", mensaje);
        return ResponseEntity.ok(response);  // Retornar la respuesta con el mensaje
    }


}
