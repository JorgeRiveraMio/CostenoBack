package com.example.CostenoBackend.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Models.Asiento;
import com.example.CostenoBackend.Models.Boleto;
import com.example.CostenoBackend.Models.BoletoDTO;
import com.example.CostenoBackend.Models.Bus;
import com.example.CostenoBackend.Models.Cliente;
import com.example.CostenoBackend.Models.EstadoBoleto;
import com.example.CostenoBackend.Models.Viaje;
import com.example.CostenoBackend.Services.BoletoService;


@RestController
@RequestMapping("/boleto")
@CrossOrigin("*")
public class BoletoController {

    @Autowired
    private BoletoService boletoService;
    @PostMapping("/registrar")
    public ResponseEntity<Map<String, String>> registrarBoleto(@RequestBody BoletoDTO boletoDTO) {
        Boleto boleto = new Boleto();
        
        boleto.setPrecio(boletoDTO.getPrecio());
        boleto.setFechaEmision(boletoDTO.getFechaEmision());
        boleto.setHoraEmision(boletoDTO.getHoraEmision());
    
        Cliente cliente = new Cliente();
        cliente.setIdPersona(boletoDTO.getIdCliente());
        boleto.setCliente(cliente);
    
        Viaje viaje = new Viaje();
        viaje.setIdViaje(boletoDTO.getIdViaje());
        boleto.setViaje(viaje);
    
        Asiento asiento = new Asiento();
        asiento.setIdAsiento(boletoDTO.getIdAsiento());
        boleto.setAsiento(asiento);
    
        Bus bus = new Bus();
        bus.setIdBus(boletoDTO.getIdBus());
        boleto.setBus(bus);
    
        return boletoService.guardar(boleto); // No es necesario verificar el estado aquí
    }
    
    


    @GetMapping("/listar")
    public List<Boleto> listar() {
        return this.boletoService.listar();
    }

     // Método para listar los boletos de un cliente específico
    @GetMapping("/listar/{idCliente}")
    public List<Boleto> listarPorCliente(@PathVariable Integer idCliente) {
        return this.boletoService.listarPorCliente(idCliente);
    }

    @GetMapping("/buscar/{id}")
    public Boleto buscarPorId(@PathVariable Integer id) {
        return this.boletoService.obtener(id);
    }
}
