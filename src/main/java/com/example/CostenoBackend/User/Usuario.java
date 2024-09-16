package com.example.CostenoBackend.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.*;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"correo"})})


public class Usuario  extends Persona implements UserDetails  {

    @Id
    @GeneratedValue
    private Integer cod_usuario;

    @OneToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Persona persona;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    
    @Column(nullable = true)
    private String tarjeta;
    private java.util.Date fecha_creacion;
    private boolean estado;
     

    
    public Usuario(Integer dni, String nombres, String apellidos, Date nacimiento, Integer cod_usuario, Persona persona,
            String username, String password, String tarjeta, Date fecha_creacion, boolean estado) {
        super(dni, nombres, apellidos, nacimiento);
        this.cod_usuario = cod_usuario;
        this.persona = persona;
        this.username = username;
        this.password = password;
        this.tarjeta = tarjeta;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
    }

    public Integer getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(Integer cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public java.util.Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(java.util.Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
         authorities.add(new SimpleGrantedAuthority("cliente"));
         return authorities;
    }

 
}
