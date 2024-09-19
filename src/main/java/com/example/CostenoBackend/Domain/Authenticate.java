package com.example.CostenoBackend.Domain;

import org.springframework.stereotype.Service;
import com.example.CostenoBackend.Infra.MailManager;

@Service
public class Authenticate {

    private final MailManager mailManager;

    public Authenticate(MailManager mailManager) {
        this.mailManager = mailManager;
    }

    public String sendMessageUser(String email) {
        return mailManager.sendMessage(email);  // Retorna el código de verificación
    }
}
