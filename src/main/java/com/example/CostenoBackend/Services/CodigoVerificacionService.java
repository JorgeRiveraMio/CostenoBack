package com.example.CostenoBackend.Services;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class CodigoVerificacionService {

    // Un mapa temporal para almacenar los códigos por correo
    private Map<String, String> codigosVerificacion = new HashMap<>();

    // Generar un código de verificación de 6 dígitos
    public String generarCodigo() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000); // Genera un número de 6 dígitos
        return String.valueOf(codigo);
    }

    // Guardar el código para un correo específico
    public void guardarCodigo(String correo, String codigo) {
        codigosVerificacion.put(correo, codigo);
    }

    // Validar si el código ingresado coincide con el almacenado
    public boolean validarCodigo(String correo, String codigoIngresado) {
        String codigoGuardado = codigosVerificacion.get(correo);
        return codigoGuardado != null && codigoGuardado.equals(codigoIngresado);
    }
}
