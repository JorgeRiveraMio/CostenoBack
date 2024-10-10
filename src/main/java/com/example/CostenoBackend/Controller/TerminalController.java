package com.example.CostenoBackend.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CostenoBackend.Models.Terminal;
import com.example.CostenoBackend.Services.TerminalService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/terminal")
@CrossOrigin("*")
public class TerminalController {

    @Autowired 
    private TerminalService terminalService;

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrar(@RequestBody Terminal terminal) {
       if(terminal== null) {
           
            Map<String, String> response = new HashMap<>();
            response.put("message", "La ruta no se registro");
            return ResponseEntity.badRequest().body(response);

        }      
        this.terminalService.guardar(terminal);
        Map<String, String> response = new HashMap<>();
        response.put("message", "La ruta  se registro");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/listar")
    public List<Terminal> listar() {
        return  this.terminalService.listar();
    }
    
}
