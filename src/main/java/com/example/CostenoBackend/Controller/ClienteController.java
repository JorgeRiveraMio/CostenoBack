package com.example.CostenoBackend.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.CostenoBackend.Domain.Authenticate;
import com.example.CostenoBackend.Models.Cliente;
import com.example.CostenoBackend.Services.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private Authenticate authenticate;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Un mapa temporal para guardar clientes pendientes de verificación
    private final Map<String, String> verificationCodes = new HashMap<>(); // Email -> Código

    private final Map<String, Cliente> pendingClients = new HashMap<>(); // Email -> Cliente

    // Enviar código de verificación al correo
    @PostMapping("/enviarCodigo")
    public ResponseEntity<Object> enviarCodigo(@RequestBody Cliente cliente) {
        // Enviar el código al correo del cliente
        String code = authenticate.sendMessageUser(cliente.getCorreo());
    
        // Guardar el correo y el código temporalmente
        verificationCodes.put(cliente.getCorreo(), code);
        pendingClients.put(cliente.getCorreo(), cliente);
    
        Map<String, String> response = new HashMap<>();
        response.put("message", "Código de verificación enviado al correo.");
        return ResponseEntity.ok(response);
    }
    

    // Validar el código ingresado por el usuario
    @PostMapping("/validarCodigo")
    public ResponseEntity<Object> validarCodigo(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String code = request.get("codigo");
    
        // Logs para depuración, esto es solo para ver el la consola los datos (es para pruebas, eliminen si quieren xd )
        System.out.println("Email recibido: " + email);
        System.out.println("Código recibido: " + code);
        System.out.println("Código esperado: " + verificationCodes.get(email));
    
        // Verificar si el código ingresado coincide con el que fue enviado
        if (verificationCodes.containsKey(email) && verificationCodes.get(email).equals(code)) {
            // Obtener el cliente temporal
            Cliente cliente = pendingClients.get(email);
    
            // Guardar el cliente en la base de datos
            String passwordEncriptado = passwordEncoder.encode(cliente.getPassword());
            cliente.setPassword(passwordEncriptado);
            this.clienteService.Guardar(cliente);
    
            // Eliminar el cliente y el código del mapa temporal
            verificationCodes.remove(email);
            pendingClients.remove(email);
    
            Map<String, String> response = new HashMap<>();
            response.put("message", "Código validado. Usuario registrado exitosamente.");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Código de verificación incorrecto.");
            return ResponseEntity.badRequest().body(response);
        }
    }    
}
