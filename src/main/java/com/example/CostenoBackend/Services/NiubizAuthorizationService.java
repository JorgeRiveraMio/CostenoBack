package com.example.CostenoBackend.Services;

import org.springframework.http.MediaType;
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
public class NiubizAuthorizationService {

    @Value("${niubiz.merchantId}")
    private String merchantId;

    @Value("${niubiz.url_authorization}")
    private String authorizationUrl;

    @Autowired
    private NiubizAuthService niubizAuthService;

    public String solicitarAutorizacion(String tokenId, String monto, String moneda, String purchaseNumber) {
        RestTemplate restTemplate = new RestTemplate();
        String accessToken = niubizAuthService.obtenerTokenDeSeguridad();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("channel", "web");
        body.put("captureType", "manual");
        body.put("countable", true);

        Map<String, Object> order = new HashMap<>();
        order.put("tokenId", tokenId);
        order.put("purchaseNumber", purchaseNumber);
        order.put("amount", monto);
        order.put("currency", moneda);
        
        body.put("order", order);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            authorizationUrl + "/" + merchantId,
            HttpMethod.POST,
            request,
            String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error al autorizar la transacción: " + response.getStatusCode());
        }
    }
}
