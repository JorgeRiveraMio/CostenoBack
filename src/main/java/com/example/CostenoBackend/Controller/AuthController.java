package com.example.CostenoBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Domain.Authenticate;
import com.example.CostenoBackend.Models.LoginRequest;



@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    Authenticate authenticate;

    //ENVIAR CORREO CON CODIGO PARA VALIDAR LA CUENTA
    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody LoginRequest LoginRequest){
        
        authenticate.sendMessageUser(LoginRequest.getEmailUser());
        
        return ResponseEntity.ok().body("CORREO ENVIADO...");
    }
}
