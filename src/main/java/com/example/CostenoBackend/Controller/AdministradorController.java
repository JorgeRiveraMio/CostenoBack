package com.example.CostenoBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CostenoBackend.Models.Administrador;
import com.example.CostenoBackend.Services.AdministradorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("administrador")
@CrossOrigin("*")
public class AdministradorController {
    
    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/registrar")
    public Administrador registrar(@RequestBody Administrador admin) {
        
        if(administradorService.obtenerUsuario(admin.getCorreo()) != null)  {
            throw new IllegalArgumentException("Correo ya registrado");
        }
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        
        return administradorService.Guardar(admin);
    }
       @GetMapping(path="buscar/{id}")
        public  Administrador BuscarPorId(@PathVariable Integer id) {
            Administrador actual = this.administradorService.Obtener(id);
        return actual;
        }

}
