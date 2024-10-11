package com.example.CostenoBackend.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Models.Cliente;
import com.example.CostenoBackend.Models.Terminal;
import com.example.CostenoBackend.Services.TerminalService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/terminal")
@CrossOrigin("*")
public class TerminalController {

    @Autowired 
    private TerminalService terminalService;

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrar(@RequestBody Terminal terminal) {
       if(terminal== null) {
           
            Map<String, String> response = new HashMap<>();
            response.put("message", "La ruta no se registro");
            return ResponseEntity.badRequest().body(response);

        }      
        this.terminalService.guardar(terminal);
        Map<String, String> response = new HashMap<>();
        response.put("message", "La ruta  se registro");
        return ResponseEntity.ok(response);
    }
        @GetMapping("/listar")
        public List<Terminal> listar() {
            return  this.terminalService.listar();
        }
        @GetMapping(path="buscar/{id}")
        public  Terminal BuscarPorId(@PathVariable Integer id) {
       
        Terminal actual = this.terminalService.Obtener(id);
      
        return actual;
        }


        @PutMapping(path="/{id}")
        public  ResponseEntity<Object>actualizarPorId(@PathVariable Integer id, @RequestBody Terminal nuevo) {
        String mensaje;
        Terminal actual = this.terminalService.Obtener(id);
        if (actual != null) {
            
          
            actual.setNombre(nuevo.getNombre());
            actual.setDireccion(nuevo.getDireccion());  
            actual.setDepartamento(nuevo.getDepartamento());
            actual.setProvincia(nuevo.getProvincia());
            actual.setDistrito(nuevo.getDistrito());
            actual.setCoordenadaLatitud(nuevo.getCoordenadaLatitud());
            actual.setCoordenadaLongitud(nuevo.getCoordenadaLongitud());
            
            this.terminalService.guardar(actual);
            mensaje = "Cliente actualizado correctamente"; // Mensaje de éxito
        } else {
            mensaje = "No se pudo actualizar el cliente"; // Mensaje de error
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", mensaje);
        return ResponseEntity.ok(response);
        }

    
}
