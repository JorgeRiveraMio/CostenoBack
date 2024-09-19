package com.example.CostenoBackend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Services.ReniecService;

@RestController
@CrossOrigin("*")
public class ConsultaDni {

    private final ReniecService reniecService;

    public ConsultaDni(ReniecService reniecService) {
        this.reniecService = reniecService;
    }

    @GetMapping("/consultar-dni")
    public String consultarDNI(@RequestParam String dni) {
        return reniecService.consultarDNI(dni);
    }
}
