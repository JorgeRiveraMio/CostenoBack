package com.example.CostenoBackend.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Domain.Authenticate;
import com.example.CostenoBackend.Models.Cliente;
import com.example.CostenoBackend.Repository.ClienteRepository;




@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {
    
    @Autowired
    Authenticate authenticate;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/guardar")
    public ResponseEntity<Object> guardar(@RequestBody Cliente cliente){

        authenticate.sendMessageUser(cliente.getCorreo());
        this.clienteRepository.save(cliente);

         Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario Registrado");
        return ResponseEntity.ok(response);
    }
    // @GetMapping("/buscarCliente/{correo}")
    // public ResponseEntity<Object>buscarCliente(@PathVariable String correo) {
    //     boolean exists = this.clienteRepository()
    //     return new String();
    // }
    
}
