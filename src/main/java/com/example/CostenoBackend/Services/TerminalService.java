package com.example.CostenoBackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.Terminal;
import com.example.CostenoBackend.Repository.TerminalRepository;

@Service
public class TerminalService {
    @Autowired
    private TerminalRepository terminalRepository;

    public List<Terminal> listar(){
        return terminalRepository.findAll();
    }
    public Terminal guardar(Terminal terminal){
        return terminalRepository.save(terminal);
    }
    public Terminal Obtener(Integer id) {
        return terminalRepository.findById(id).orElse(null);
    }
}
