package com.example.CostenoBackend.Services;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.CostenoBackend.Models.Boleto;

import com.example.CostenoBackend.Models.EstadoBoleto;
import com.example.CostenoBackend.Repository.BoletoRepository;
import com.example.CostenoBackend.Repository.EstadoBoletoRepository;


@Service
public class BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;

    @Autowired
    private EstadoBoletoRepository estadoBoletoRepository; ///

    public List<Boleto> listar() {
        return boletoRepository.findAll();
    }

     // Método para listar los boletos de un cliente específico
    public List<Boleto> listarPorCliente(Integer idCliente) {
        return boletoRepository.findByClienteId(idCliente);
    }

    public Boleto obtener(Integer id) {
        Boleto boleto = boletoRepository.findBoletoById(id);
        System.out.println("ID del boleto obtenido: " + (boleto != null ? boleto.getIdBoleto() : "No encontrado"));
        return boleto;
    }

    public ResponseEntity<Map<String, String>> guardar(Boleto boleto) {
        Map<String, String> response = new HashMap<>();
        try {
            EstadoBoleto estadoActivo = estadoBoletoRepository.findByEstado("ACTIVO")
                .orElseThrow(() -> new IllegalArgumentException("EstadoBoleto 'Activo' no encontrado"));
            
            boleto.setEstadoBoleto(estadoActivo);
    
            // Guarda el boleto en la base de datos
            Boleto boletoGuardado = boletoRepository.save(boleto);
    
            // Agregar el ID del boleto al mapa de respuesta
            response.put("message", "Boleto registrado correctamente");
            response.put("idBoleto", String.valueOf(boletoGuardado.getIdBoleto()));  // Incluir el idBoleto
    
            // Devolver el mapa con el mensaje y el ID del boleto
            return ResponseEntity.ok(response);
    
        } catch (Exception e) {
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    

    public List<Boleto> actualizarBoletosVencidos() {
        LocalDateTime ahora = LocalDateTime.now();
        List<Boleto> boletosVencidos = boletoRepository.findBoletosVencidos(ahora);
    
        for (Boleto boleto : boletosVencidos) {
            EstadoBoleto estadoInactivo = new EstadoBoleto();
            estadoInactivo.setIdEstadoBoleto(2); 
            boleto.setEstadoBoleto(estadoInactivo); 
            boletoRepository.save(boleto);
        }
    
        return boletosVencidos;
    }
    
}
