package com.example.CostenoBackend;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class CostenoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostenoBackendApplication.class, args);
	}
	@PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
    }

}
