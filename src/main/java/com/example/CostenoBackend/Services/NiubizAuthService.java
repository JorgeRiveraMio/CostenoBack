package com.example.CostenoBackend.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class NiubizAuthService {

    @Value("${niubiz.user}")
    private String user;

    @Value("${niubiz.password}")
    private String password;

    @Value("${niubiz.url_auth}")
    private String authUrl;

    public String obtenerTokenDeSeguridad() {
        RestTemplate restTemplate = new RestTemplate();

        // Codificar credenciales en Base64
        String auth = user + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

        // Configura los encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + encodedAuth);

        HttpEntity<String> request = new HttpEntity<>(headers);

        // Enviar solicitud para obtener el token de seguridad
        ResponseEntity<String> response = restTemplate.exchange(authUrl, HttpMethod.GET, request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody(); // Este es el `accessToken`
        } else {
            throw new RuntimeException("Error al generar el token de seguridad: " + response.getStatusCode());
        }
    }
}
