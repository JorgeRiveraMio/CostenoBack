package com.example.CostenoBackend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CostenoBackend.Models.Asiento;

import com.example.CostenoBackend.Repository.AsientoRepository;


@Service
public class AsientoService {
 @Autowired
    private AsientoRepository asientoRepository;

        public List< Asiento> buscarPorCodBus(Integer id) {
        return asientoRepository.findByBusIdBus(id);
    }
}
