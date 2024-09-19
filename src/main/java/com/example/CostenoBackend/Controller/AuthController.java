package com.example.CostenoBackend.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Config.JwtService;
import com.example.CostenoBackend.Models.Administrador;
import com.example.CostenoBackend.Models.Cliente;
import com.example.CostenoBackend.Models.Empleado;
import com.example.CostenoBackend.Models.JwtRequest;
import com.example.CostenoBackend.Models.JwtResponse;
import com.example.CostenoBackend.Services.AdministradorService;
import com.example.CostenoBackend.Services.ClienteService;
import com.example.CostenoBackend.Services.Impl.UserDetailsServiceImpl;


@RestController
@CrossOrigin("*")
public class AuthController {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private JwtService jwtUtils;

    // este metodo es para que los usuarios ingresen sesion y se les genere el token 
    // esta dise;ado para procesar las solicitudes en formato Json 
    // JwtRequest contiene el correo y la contraseña del usuario
    @PostMapping("/ingresar")
        public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {   
            autenticar(jwtRequest.getCorreo(), jwtRequest.getPassword());//se valida el correo y la contraseña
        } catch (DisabledException exception) { 
            throw new Exception("Usuario deshabilitado: " + exception.getMessage());// sino lanza la excepcion 
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales inválidas: " + e.getMessage()); // sino lanza la excepcion 
        } catch (Exception exception) {
            throw new Exception("Error durante la autenticación: " + exception.getMessage()); // sino lanza la excepcion 
        }
    
        //si la autenticacion es exitosa, se van a cargar los datos del usuario desde la bd utilizando userDetailsService
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getCorreo());
        String token = this.jwtUtils.getToken(userDetails);// al cargar la info del usuario entonces se genera el token
        return ResponseEntity.ok(new JwtResponse(token));// retorna el token
    }

    //se encarga de validar que el correo y la contraseña sean correctas 
    private void autenticar(String username, String password) throws Exception {
        Cliente cliente = clienteService.obtenerUsuario(username);// se busca en cliente
        Administrador admin = administradorService.obtenerUsuario(username);// se busca en admin 

        //al encontrar al cliente o al admin se procede con la validacion de contraseña
        if (cliente != null) {
        if (!passwordEncoder.matches(password, cliente.getPassword())) { // compara la contraseña brindada con la que se encuentra en la bd 
            throw new BadCredentialsException("Credenciales inválidas");
        }
        } else if (admin != null) {
        if (!passwordEncoder.matches(password, admin.getPassword())) {
            throw new BadCredentialsException("Credenciales inválidas");
        }
        } else {
        throw new UsernameNotFoundException("Usuario no encontrado");// si no encuentra ningun usuario, manda una excepcion
    }
    }

    //metodo para mostrar al usuario que pudo iniciar sesion 
    // PRINCIPAL es un objeto que contiene al usuario que fue autenticado, Spring Security se lo da automaticamente
    @GetMapping("/actual-usuario")
    public ResponseEntity<?> obtenerUsuarioActual(Principal principal) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(principal.getName());//toma el nombre de usuario en nuestro caso el correo
        if (userDetails instanceof Cliente) {// si el usuario es un cliente, pues devuelve su informacion
            return ResponseEntity.ok((Cliente) userDetails);
        } else if (userDetails instanceof Empleado) {// si el usuario es un admin, pues devuelve su informacion
            return ResponseEntity.ok((Empleado) userDetails);
        }
        return ResponseEntity.badRequest().body("Usuario no encontrado");//si no se encuentra entonces no hay usuario 
    }
}
