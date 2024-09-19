package com.example.CostenoBackend.Config;

import java.io.IOException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*se implementa AuthenticationEntryPoint, se usa para los usuarios que no estan autenticados 
y quieren acceder a los recursos que requieren una autorizacion*/
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
    
    // HttpServletRequest contiene los detalles de la solicitud HTTP que se está haciendo
    // HttpServletResponse modifica la respuesta HTTP que es enviada al cliente como el codigo del estado
    // AuthenticationException contiene los detalles de los errores por el que este metodo fue invocado

    // por ejemplo si se envia el error 401 UNAUTHORIZED, pues el metodo hace que se muestre como "Usuario no autorizado"
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario no autorizado");
    }
}
