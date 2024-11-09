package com.example.CostenoBackend.Services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.CostenoBackend.Models.Boleto;
import com.example.CostenoBackend.Models.Bus;
import com.example.CostenoBackend.Models.EstadoBoleto;
import com.example.CostenoBackend.Repository.BoletoRepository;
import com.example.CostenoBackend.Repository.EstadoBoletoRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;

    @Autowired
    private EstadoBoletoRepository estadoBoletoRepository; ///

      public List<Boleto> listar() {
        return boletoRepository.findAll();
    }

    public Boleto obtener(Integer id) {
        return boletoRepository.findById(id).orElse(null);
    }

    public ResponseEntity<Map<String, String>> guardar(Boleto boleto) {
        Map<String, String> response = new HashMap<>();
        try {
            EstadoBoleto estadoActivo = estadoBoletoRepository.findByEstado("ACTIVO")
                .orElseThrow(() -> new IllegalArgumentException("EstadoBoleto 'Activo' no encontrado"));
                    
            boleto.setEstadoBoleto(estadoActivo);
    
            boletoRepository.save(boleto);
    
            response.put("message", "Boleto registrado correctamente");
            return ResponseEntity.ok(response);
    
        } catch (Exception e) {
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
}
