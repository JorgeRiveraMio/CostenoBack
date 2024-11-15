package com.example.CostenoBackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class NiubizSessionService {

    @Value("${niubiz.merchantId}")
    private String merchantId;

    @Value("${niubiz.url_session}")
    private String sessionUrl;

    @Autowired
    private NiubizAuthService niubizAuthService;

    public String crearTokenDeSesion(String monto, String moneda, Map<String, Object> antifraudData) {
        RestTemplate restTemplate = new RestTemplate();
        String accessToken = niubizAuthService.obtenerTokenDeSeguridad();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("Content-Type", "application/json");

        Map<String, Object> body = new HashMap<>();
        body.put("channel", "web");
        body.put("amount", monto);
        body.put("antifraud", antifraudData);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            sessionUrl + "/" + merchantId,
            HttpMethod.POST,
            request,
            String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody(); // Este es el `sessionKey`
        } else {
            throw new RuntimeException("Error al crear el token de sesión: " + response.getStatusCode());
        }
    }
}
