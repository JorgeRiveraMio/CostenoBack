package com.example.CostenoBackend.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.Administrador;
import com.example.CostenoBackend.Models.Cliente;
import com.example.CostenoBackend.Repository.AdministradorRepository;
import com.example.CostenoBackend.Repository.ClienteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AdministradorRepository administradorRepository;


    //se va realizar la busqueda y validacion del usuario por su correo
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByCorreo(correo);//busca al cliente por su correo
        if (cliente != null) {
            return cliente; //si logra encontrar una coincidencia pues retorna a ese usuario
        }

        Administrador admin = administradorRepository.findByCorreo(correo);// busca al admin por su correo
        if (admin != null) {
            return admin; //si logra encontrar una coincidencia pues retorna a ese usuario
        }
        throw new UsernameNotFoundException("Usuario no encontrado"); // si no encuentra un usuario lanza una excepcion 
    }
}
