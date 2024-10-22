package com.example.CostenoBackend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public ResponseEntity<String> registrar(@RequestBody Bus bus) {
        String mensajeError = busService.guardar(bus);
        
        if (mensajeError.isEmpty()) {
            return new ResponseEntity<>("Bus creado exitosamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(mensajeError, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "actualizarEstado/{id}")
    public ResponseEntity<String> actualizarEstado(@PathVariable Integer id) {
        String mensajeError = busService.alternarEstadoBusPorId(id);
        
        if (mensajeError.isEmpty()) {
            return new ResponseEntity<>("Bus cambio de estado", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(mensajeError, HttpStatus.BAD_REQUEST);
        }
    }
    
 
}
