package com.example.CostenoBackend.Models;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "idPersona")//aseguramos que sepa que idPersona es la fk
public class Cliente extends Persona implements UserDetails{

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String password;

    //fk de estado de cliente
    @ManyToOne
    @JoinColumn(name = "idEstadoCliente", referencedColumnName = "idEstadoCliente")
    private EstadoCliente estadoCliente;

    public Cliente() {
    }

    public Cliente(String correo, String password, EstadoCliente estadoCliente) {
        this.correo = correo;
        this.password = password;
        this.estadoCliente = estadoCliente;
    }

    public Cliente(int idPersona, int numDocumento, String nombres, String apellidos, String estadoCivil,
            String direccion, String numTel, Date fechaNac, Date fechaCreacion, String correo, String password,
            EstadoCliente estadoCliente) {
        super(idPersona, numDocumento, nombres, apellidos, estadoCivil, direccion, numTel, fechaNac, fechaCreacion);
        this.correo = correo;
        this.password = password;
        this.estadoCliente = estadoCliente;
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

    public EstadoCliente getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(EstadoCliente estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("cliente"));
        return authorities;
    }

    

    @Override
    public String getUsername() {
        return this.correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}

