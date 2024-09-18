package com.example.CostenoBackend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Services.ReniecService;

@RestController
public class ConsultaDni {

    private final ReniecService reniecService;

    public ConsultaDni(ReniecService reniecService) {
        this.reniecService = reniecService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/consultar-dni")
    public String consultarDNI(@RequestParam String dni) {
        return reniecService.consultarDNI(dni);
    }
}