package com.example.CostenoBackend.Infra;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.util.*;

@Component
public class MailManager {
    
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public MailManager(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMessage(String emailUser) {
        
        MimeMessage message = javaMailSender.createMimeMessage();
        String content = MessageHTML.TEMPLATE_PRUEBA;
        String code = generateRandomCode();

        try {
            message.setSubject("Confirmación de Registro!!");
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(emailUser);

            //logica para enviar codigos
            int index = 0;
            for (int i=0; i< code.length(); i++){
                content = setCodeInTemplate(content, index, String.valueOf(code.charAt(i)));
                index++;
            
            }

            helper.setText(content, true);
            helper.setFrom(sender);
            javaMailSender.send(message);

        }catch(MessagingException e ){
            throw new RuntimeException(e);
        }
    }

    private String generateRandomCode() {
        Random random = new Random();
        int randomCode = 100000 + random.nextInt(900000); // Genera un número entre 100000 y 999999
        return String.valueOf(randomCode);
    }

    private String setCodeInTemplate(String templateCode, int index, String number){
        return templateCode.replace("{" + index + "}", number);
    }
}
