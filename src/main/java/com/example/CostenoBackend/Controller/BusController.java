package com.example.CostenoBackend.Controller;


import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CostenoBackend.Models.Bus;
import com.example.CostenoBackend.Services.BusService;



@RestController
@RequestMapping("/bus")
@CrossOrigin("*")
public class BusController {
    @Autowired
    private BusService busService;
    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Bus bus) {
    ResponseEntity<?> mensajeError = busService.guardar(bus);

    if (mensajeError.getStatusCode() == HttpStatus.BAD_REQUEST) {
        return mensajeError;
    } else {
        // Crear un objeto JSON para la respuesta
        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("message", "Bus registrado con éxito");
        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }
}
    

    @GetMapping("/listar")
    public List<Bus> listar() {
        return this.busService.listar();
    }

    @GetMapping("/buscar/{id}")
    public Bus buscarPorId(@PathVariable Integer id) {
        return this.busService.obtener(id);
    }

    @PutMapping(path = "actualizarEstado/{id}")
    public ResponseEntity<?> actualizarEstado(@PathVariable Integer id) {
        ResponseEntity<?> mensajeError = busService.alternarEstadoBusPorId(id);
        
        if (mensajeError.getStatusCode() == HttpStatus.OK) {
            // Crear un objeto JSON para la respuesta
            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("message", "Cambio de estado del bus exitoso");
            return ResponseEntity.ok(successResponse);
        } else {
            return mensajeError; 
        }
    }
    
    
}

