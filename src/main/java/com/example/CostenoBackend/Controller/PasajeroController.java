package com.example.CostenoBackend.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Models.Pasajero;
import com.example.CostenoBackend.Services.PasajeroService;

@RestController
@RequestMapping("/pasajero")
@CrossOrigin("*")
public class PasajeroController {

    @Autowired 
    private PasajeroService pasajeroService;

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrar(@RequestBody Pasajero pasajero) {
        if (pasajero == null) {

            Map<String, String> response = new HashMap<>();
            response.put("message", "El pasajero no se registró");
            return ResponseEntity.badRequest().body(response);
        }      
        this.pasajeroService.guardar(pasajero);
        Map<String, String> response = new HashMap<>();
        response.put("message", "El pasajero se registró");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    public List<Pasajero> listar() {
        return this.pasajeroService.listar();
    }

    @GetMapping("/buscar/{id}")
    public Pasajero buscarPorId(@PathVariable Integer id) {
        return this.pasajeroService.obtener(id);
    }
    
}
