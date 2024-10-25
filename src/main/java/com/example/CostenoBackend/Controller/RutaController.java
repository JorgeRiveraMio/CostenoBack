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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Models.Administrador;
import com.example.CostenoBackend.Models.Ruta;
import com.example.CostenoBackend.Models.RutaDTO;
import com.example.CostenoBackend.Models.Terminal;
import com.example.CostenoBackend.Services.AdministradorService;
import com.example.CostenoBackend.Services.RutaService;
import com.example.CostenoBackend.Services.TerminalService;



@RestController
@RequestMapping("/ruta")
@CrossOrigin("*")
public class RutaController {
    @Autowired 
    private RutaService rutaService;

    @Autowired 
    private TerminalService terminalService;

    @Autowired 
    private AdministradorService administradorService;

   
    
    @PostMapping("/registrar")
    public ResponseEntity<Object> registrarRuta(@RequestBody RutaDTO rutaDTO) {
        // Convierte RutaDTO a Ruta
        Ruta ruta = new Ruta();
        ruta.setDistancia(rutaDTO.getDistancia());
        ruta.setDuracion(rutaDTO.getDuracion());
        ruta.setEstadoRuta(rutaDTO.getEstadoRuta());
        
        // Aquí deberías cargar las entidades de Terminal y Administrador usando sus IDs
        Terminal terminalOrigen = terminalService.Obtener(rutaDTO.getIdTerminalOrigen());
        Terminal terminalDestino = terminalService.Obtener(rutaDTO.getIdTerminalDestino());
        Administrador administrador = administradorService.Obtener(rutaDTO.getIdAdministrador());

        ruta.setTerminalOrigen(terminalOrigen);
        ruta.setTerminalDestino(terminalDestino);
        ruta.setAdministrador(administrador);

        // Guardar la ruta en la base de datos
        rutaService.guardar(ruta);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Ruta registrada correctamente");
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
public ResponseEntity<Object> actualizarPorId(@PathVariable Integer id, @RequestBody RutaDTO nuevo) {
    String mensaje;
    Ruta actual = this.rutaService.obtener(id);
    
    if (actual != null) {   
        actual.setDistancia(nuevo.getDistancia());
        actual.setDuracion(nuevo.getDuracion()); // Asegúrate de que el formato sea HH:mm:ss
        actual.setEstadoRuta(nuevo.getEstadoRuta());

        // Actualiza las relaciones utilizando el servicio para obtener las entidades por ID
        Terminal terminalOrigen = terminalService.Obtener(nuevo.getIdTerminalOrigen());
        Terminal terminalDestino = terminalService.Obtener(nuevo.getIdTerminalDestino());
        Administrador administrador = administradorService.Obtener(nuevo.getIdAdministrador());

        actual.setTerminalOrigen(terminalOrigen);
        actual.setTerminalDestino(terminalDestino);
        actual.setAdministrador(administrador);

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
      @GetMapping("/buscar")
    public Ruta buscarRutaPorTerminales(@RequestParam String nombreOrigen, @RequestParam String nombreDestino) {
        return rutaService.buscarRutaPorTerminales(nombreOrigen, nombreDestino);
    }
}
