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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Models.Ruta;

import com.example.CostenoBackend.Services.RutaService;



@RestController
@RequestMapping("/ruta")
@CrossOrigin("*")
public class RutaController {
    @Autowired 
    private RutaService rutaService;

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrar(@RequestBody Ruta ruta) {
        if(ruta == null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "La ruta no se registró");
            return ResponseEntity.badRequest().body(response);
        }
        System.out.println(ruta.getIdRuta());
        this.rutaService.guardar(ruta);
        Map<String, String> response = new HashMap<>();
        response.put("message", "La ruta se registró correctamente");
        return ResponseEntity.ok(response);
    }
        @GetMapping("/listar")
        public List<Ruta> listar() {
            return  this.rutaService.listar();
        }
        @GetMapping(path="buscar/{id}")
        public  Ruta BuscarPorId(@PathVariable Integer id) {
            Ruta actual = this.rutaService.obtener(id);
        return actual;
        }
          @PutMapping(path = "/{id}")
    public ResponseEntity<Object> actualizarPorId(@PathVariable Integer id, @RequestBody Ruta nuevo) {
        String mensaje;
        Ruta actual = this.rutaService.obtener(id);
        
        if (actual != null) {   
            actual.setDistancia(nuevo.getDistancia());
            actual.setDuracion(nuevo.getDuracion());
            actual.setEstadoRuta(nuevo.getEstadoRuta());
            // Actualiza las relaciones si es necesario
            actual.setTerminalOrigen(nuevo.getTerminalOrigen());
            actual.setTerminalDestino(nuevo.getTerminalDestino());
            actual.setAdministrador(nuevo.getAdministrador());

            this.rutaService.guardar(actual);
            mensaje = "Ruta actualizada correctamente"; // Mensaje de éxito
        } else {
            mensaje = "No se pudo actualizar la ruta"; // Mensaje de error
        }
        
        Map<String, String> response = new HashMap<>();
        response.put("message", mensaje);
        return ResponseEntity.ok(response);
    }

    // Método para actualizar el estado de una ruta
    @PutMapping(path = "actualizarEstado/{id}")
    public ResponseEntity<Object> actualizarEstado(@PathVariable Integer id) {
        String mensaje;
        Ruta actual = this.rutaService.obtener(id);
    
        if (actual != null) {
            if (actual.getEstadoRuta().equals("activo")) {  // Comparación correcta con equals()
                actual.setEstadoRuta("inactivo");
                mensaje = "El estado pasó a inactivo";
            } else {
                actual.setEstadoRuta("activo");
                mensaje = "El estado pasó a activo";
            }
    
            this.rutaService.guardar(actual);  // Guardar el estado actualizado
        } else {
            mensaje = "El estado no se actualizó correctamente";  // Mensaje de error
        }
    
        // Crear un mapa para la respuesta
        Map<String, String> response = new HashMap<>();
        response.put("message", mensaje);
        return ResponseEntity.ok(response);  // Retornar la respuesta con el mensaje
    }
}
