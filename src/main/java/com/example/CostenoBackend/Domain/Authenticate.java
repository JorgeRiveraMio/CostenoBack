package com.example.CostenoBackend.Domain;

import org.springframework.stereotype.Service;
import com.example.CostenoBackend.Infra.MailManager;

@Service
public class Authenticate {
    
    MailManager mailManager;

    public Authenticate(MailManager mailManager) {
        this.mailManager = mailManager;
    }

    public void sendMessageUser(String email){
        mailManager.sendMessage(email);
    }
}
