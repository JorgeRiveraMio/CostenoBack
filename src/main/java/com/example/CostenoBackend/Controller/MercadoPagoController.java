package com.example.CostenoBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.CostenoBackend.Models.CompraGeneral;
import com.example.CostenoBackend.Services.MercadoPagoService;
import com.mercadopago.resources.preference.Preference;

@RestController
@CrossOrigin("*")
@RequestMapping("/mercadoPago")
public class MercadoPagoController {

    @Autowired
    private MercadoPagoService mercadoPagoService;

    @PostMapping("/crear-preferencia")
    public Preference crearPreferencia(@RequestBody CompraGeneral compra) {
        return mercadoPagoService.crearPreferencia(compra);
    }

    @GetMapping("/notificacion-pago")
    public String recibirNotificacionPago(@RequestParam String payment_id, 
                                            @RequestParam String status, 
                                            @RequestParam String external_reference,
                                            @RequestParam String merchant_order_id) {
        // Lógica para manejar la notificación del estado del pago
        System.out.println("Pago recibido: " + payment_id);
        System.out.println("Estado del pago: " + status);
        // Procesar la notificación y redirigir al cliente si es necesario
        return "Pago procesado correctamente";
    }
}

