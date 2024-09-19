package com.example.CostenoBackend.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.*;
import com.example.CostenoBackend.Models.Administrador;
import com.example.CostenoBackend.Models.Cliente;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.example.CostenoBackend.Repository.AdministradorRepository;
import com.example.CostenoBackend.Repository.ClienteRepository;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

//se implementa la interfaz AuthenticationProvider
@Component
public class CustomUserDetailsService implements AuthenticationProvider  {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    //realiza la logica de autenticacion
    //Authentication es una interaz de spring security que toma la informacion de usuario que quiere inciar sesion
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String correo = authentication.getName();// toma el nombre de usuario pero en nuestro caso toma el correo
        String password = authentication.getCredentials().toString(); // toma la contraseña del usuario 

        // Primero intenta autenticar como cliente
        Cliente cliente = clienteRepository.findByCorreo(correo);
        if (cliente != null && password.equals(cliente.getPassword())) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            return new UsernamePasswordAuthenticationToken(correo, password, authorities);
        }

        // Si no es cliente, intenta autenticar como empleado
        Administrador admin = administradorRepository.findByCorreo(correo);
        if (admin != null && password.equals(admin.getPassword())) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            return new UsernamePasswordAuthenticationToken(correo, password, authorities);
        }

        // Si ninguna autenticación es exitosa, lanza excepción
        throw new BadCredentialsException("Credenciales inválidas");
    }

    //indica que tipo de autenticacion es compatible para este 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}