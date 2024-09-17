package com.example.CostenoBackend.Controller;

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
        return  ResponseEntity.ok().body("Usuario Registrado..");
    }
}
