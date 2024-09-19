package com.example.CostenoBackend.Models;

public class JwtRequest {
    private String correo;
    private String password;

    public JwtRequest(){

    }
    
    public JwtRequest(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
