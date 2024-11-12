package com.example.CostenoBackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Models.Asiento;
import com.example.CostenoBackend.Services.AsientoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/asiento")
@CrossOrigin("*")
public class AsientoController {
    @Autowired
    private AsientoService asientoService;

    @GetMapping("/buscarPorCodBus/{id}")
    public List<Asiento> buscarPorCodBus(@PathVariable Integer id) {
        return asientoService.buscarPorCodBus(id);
    }
    
    @PutMapping("/actualizarEstado")
    public void actualizarEstadoAsiento(@RequestParam Integer idAsiento, @RequestParam Integer nuevoEstadoId) {
        asientoService.actualizarEstado(idAsiento, nuevoEstadoId);
    }
}
