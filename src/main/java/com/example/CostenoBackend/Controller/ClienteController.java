package com.example.CostenoBackend.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.CostenoBackend.Domain.Authenticate;
import com.example.CostenoBackend.Infra.MailManager;
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

    @Autowired
    private MailManager mailManager;

    // Un mapa temporal para guardar clientes pendientes de verificación
    private final Map<String, String> verificationCodes = new HashMap<>(); // Email -> Código

    private final Map<String, Cliente> pendingClients = new HashMap<>(); // Email -> Cliente

    // Enviar código de verificación al correo
    @PostMapping("/enviarCodigo")
    public ResponseEntity<Object> enviarCodigo(@RequestBody Cliente cliente) {
        // Validar si el correo ya esta registrado 
        if(clienteService.obtenerUsuario(cliente.getCorreo()) != null) {
           
            Map<String, String> response = new HashMap<>();
            response.put("message", "El correo ya está registrado.");
            return ResponseEntity.badRequest().body(response);

        }
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

    @PutMapping(path="/{id}")
    public ResponseEntity<Object>  actualizarPorId(@PathVariable Integer id, @RequestBody Cliente nuevo) {
        String mensaje;

        Cliente actual = this.clienteService.Obtener(id);
        if (actual != null) {
            // Encriptar la nueva contraseña
            // String passwordEncriptado = passwordEncoder.encode(nuevo.getPassword());
          
            actual.setEstadoCivil(nuevo.getEstadoCivil());
            actual.setDireccion(nuevo.getDireccion());
            actual.setNumTel(nuevo.getNumTel());
            actual.setFechaNac(nuevo.getFechaNac());
            // actual.setPassword(passwordEncriptado); // Establece la contraseña encriptada
            
            this.clienteService.Guardar(actual);
            mensaje = "Cliente actualizado correctamente"; // Mensaje de éxito
        } else {
            mensaje = "No se pudo actualizar el cliente"; // Mensaje de error
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", mensaje);
        return ResponseEntity.ok(response);
    }


    @PutMapping(path="/cambiarContrasena")
    public ResponseEntity<Object> cambiarContrasena(@RequestBody Map<String, String> datos) {
        String mensaje;
        String correo = datos.get("correo");
        Cliente actual = this.clienteService.obtenerUsuario(correo);
        if (actual != null) {
            String contrasenaTemporal = mailManager.generarContrasenaTemporal();

            String contrasenaEnviada = mailManager.sendTemporaryPassword(correo, contrasenaTemporal);

            String contrasenaEncriptada = passwordEncoder.encode(contrasenaEnviada);
            actual.setPassword(contrasenaEncriptada); 

            this.clienteService.Guardar(actual);
            mensaje = "Se ha enviado una contraseña temporal al correo.";
        } else {
            mensaje = "No se encontró un usuario con ese correo."; 
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", mensaje);
        return ResponseEntity.ok(response);
    }
}
