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

import com.example.CostenoBackend.Models.Boleto;
import com.example.CostenoBackend.Models.Pasajero;
import com.example.CostenoBackend.Models.PasajeroDTO;
import com.example.CostenoBackend.Services.BoletoService;
import com.example.CostenoBackend.Services.PasajeroService;
import com.mercadopago.net.HttpStatus;

@RestController
@RequestMapping("/pasajero")
@CrossOrigin("*")
public class PasajeroController {

    @Autowired 
    private PasajeroService pasajeroService;

    @Autowired
    private BoletoService boletoService;

    @PostMapping("/registrar")
    public ResponseEntity<Map<String, String>> registrarPasajero(@RequestBody PasajeroDTO pasajeroDTO) {
        Map<String, String> response = new HashMap<>();

        try {
            Boleto boleto = null;

            // Solo buscar el boleto si el idBoleto no es nulo
            if (pasajeroDTO.getIdBoleto() != null) {
                System.out.println("ID del boleto recibido en el DTO: " + pasajeroDTO.getIdBoleto());
                boleto = boletoService.obtener(pasajeroDTO.getIdBoleto());

                // Verificar que el boleto exista
                if (boleto == null) {
                    response.put("message", "El boleto con ID " + pasajeroDTO.getIdBoleto() + " no existe.");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
                }
            }

            // Convertir el PasajeroDTO a la entidad Pasajero
            Pasajero pasajero = new Pasajero();
            pasajero.setIdPasajero(pasajeroDTO.getIdPasajero());
            pasajero.setNumDocumento(pasajeroDTO.getNumDocumento());
            pasajero.setNombres(pasajeroDTO.getNombres());
            pasajero.setApellidos(pasajeroDTO.getApellidos());
            pasajero.setFecNacimiento(pasajeroDTO.getFecNacimiento());
            pasajero.setBoleto(boleto); // Puede ser nulo

            // Guardar el pasajero
            pasajeroService.guardar(pasajero);

            response.put("message", "Pasajero registrado exitosamente.");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("message", "Error al registrar pasajero: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
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
