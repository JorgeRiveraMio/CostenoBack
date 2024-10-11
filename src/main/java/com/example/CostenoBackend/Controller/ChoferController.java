package com.example.CostenoBackend.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CostenoBackend.Models.Chofer;
import com.example.CostenoBackend.Services.ChoferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/chofer")
@CrossOrigin("*")
public class ChoferController {

    @Autowired 
    private ChoferService choferService;

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrar(@RequestBody Chofer chofer) {
        if (chofer == null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "El chofer no se registró");
            return ResponseEntity.badRequest().body(response);
        }      
        this.choferService.guardar(chofer);
        Map<String, String> response = new HashMap<>();
        response.put("message", "El chofer se registró");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    public List<Chofer> listar() {
        return this.choferService.listar();
    }

    @GetMapping("/buscar/{id}")
    public Chofer buscarPorId(@PathVariable Integer id) {
        return this.choferService.obtener(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarPorId(@PathVariable Integer id, @RequestBody Chofer nuevoChofer) {
        String mensaje;
        Chofer actualChofer = this.choferService.obtener(id);
        if (actualChofer != null) {   
            actualChofer.setNumDocumento(nuevoChofer.getNumDocumento());
            actualChofer.setNombres(nuevoChofer.getNombres());
            actualChofer.setApellidos(nuevoChofer.getApellidos());
            actualChofer.setEstadoCivil(nuevoChofer.getEstadoCivil());
            actualChofer.setDireccion(nuevoChofer.getDireccion());
            actualChofer.setNumTel(nuevoChofer.getNumTel());
            actualChofer.setFechaNac(nuevoChofer.getFechaNac());
            actualChofer.setFechaLicencia(nuevoChofer.getFechaLicencia());
            actualChofer.setLicenciaConducir(nuevoChofer.getLicenciaConducir());
            actualChofer.setEstado(nuevoChofer.isEstado());
            
            this.choferService.guardar(actualChofer);
            mensaje = "Chofer actualizado correctamente";
        } else {
            mensaje = "No se pudo actualizar el chofer";
        }
        Map<String, String> response = new HashMap<>();
        response.put("message", mensaje);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/cambiar-estado/{id}/{nuevoEstado}")
        public ResponseEntity<Object> cambiarEstado(@PathVariable Integer id, @PathVariable boolean nuevoEstado) {
            Chofer choferActualizado = choferService.cambiarEstado(id, nuevoEstado);
            Map<String, String> response = new HashMap<>();

            if (choferActualizado != null) {
                response.put("message", "Estado del chofer actualizado correctamente");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "No se pudo actualizar el estado del chofer");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
    }

}
