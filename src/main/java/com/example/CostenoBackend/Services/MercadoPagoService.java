package com.example.CostenoBackend.Services;

import java.math.BigDecimal;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Config.MercadoPagoConfigUtils;
import com.example.CostenoBackend.Models.CompraGeneral;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;  // Asegúrate de importar este paquete
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

@Service
public class MercadoPagoService {

    public Preference crearPreferencia(CompraGeneral compra) {
        try {
            // Configurar credenciales de Mercado Pago
            MercadoPagoConfigUtils.configurar();

            // Calcular el precio unitario
            BigDecimal precioUnitario = BigDecimal.valueOf(compra.getPrecioTotal() / compra.getCantidadBoletos());

            // Crear el ítem de la preferencia
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .title(compra.getNombre()) // Nombre del producto/servicio
                    .description(compra.getDescripcion()) // Descripción de la compra
                    .quantity(compra.getCantidadBoletos()) // Cantidad de boletos
                    .currencyId("PEN") // Moneda
                    .unitPrice(precioUnitario) // Precio unitario
                    .build();

            // Configurar las URLs de retorno
            PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                    .success("https://localhost:4200/success")  // cambiar la url pero no puede ser local
                    .pending("https://f486-38-253-146-176.ngrok-free.app/mis-viajes/pending")  
                    .failure("https://f486-38-253-146-176.ngrok-free.app/mis-viajes/failure")  
                    .build();

            // Crear la preferencia
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(Collections.singletonList(itemRequest)) 
                    .backUrls(backUrls) 
                    .build();

            // Crear cliente de preferencia
            PreferenceClient client = new PreferenceClient();

            // Crear la preferencia en Mercado Pago
            return client.create(preferenceRequest);

        } catch (MPException | MPApiException e) {
            // Manejo de excepciones
            System.out.println("Error al crear la preferencia: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
