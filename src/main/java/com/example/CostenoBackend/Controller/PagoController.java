package com.example.CostenoBackend.Controller;

import com.example.CostenoBackend.Services.NiubizSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PagoController {

    @Autowired
    private NiubizSessionService niubizSessionService;

    @GetMapping("/iniciar-pago")
    public String iniciarPago(@RequestParam String monto, @RequestParam String moneda) {
        // Datos de antifraude de ejemplo
        Map<String, Object> antifraudData = new HashMap<>();
        antifraudData.put("clientIp", "192.168.1.1");
        antifraudData.put("merchantDefineData", Map.of(
            "MDD4", "integraciones@niubiz.com.pe",
            "MDD32", "123456789",
            "MDD75", "Registrado",
            "MDD77", 458
        ));

        return niubizSessionService.crearTokenDeSesion(monto, moneda, antifraudData);
    }
}
