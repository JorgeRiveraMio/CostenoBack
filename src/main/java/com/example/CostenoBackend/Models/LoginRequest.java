package com.example.CostenoBackend.Models;

import lombok.Builder;

@Builder
public class LoginRequest {

    private String emailUser;
    private String message;
    private String code;


    public LoginRequest() {
    }

    public LoginRequest(String emailUser, String message, String code) {
        this.emailUser = emailUser;
        this.message = message;
        this.code = code;
    }

    public String getEmailUser() {
        return emailUser;
    }
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
