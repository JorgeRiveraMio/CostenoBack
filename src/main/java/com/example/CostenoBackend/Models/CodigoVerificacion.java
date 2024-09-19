package com.example.CostenoBackend.Models;

public class CodigoVerificacion {
    private String correo;  // Puedes eliminar este campo si no es necesario
    private String codigo;

    public CodigoVerificacion() {

    }

    public CodigoVerificacion(String correo, String codigo) {
        this.correo = correo;
        this.codigo = codigo;
    }

    // Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}

