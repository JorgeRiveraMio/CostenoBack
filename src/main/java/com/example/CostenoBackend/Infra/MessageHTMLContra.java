package com.example.CostenoBackend.Infra;

public class MessageHTMLContra {
    
    public static final String TEMPLATE_CONTRASENA_TEMPORAL = "<html lang=\"en\">\r\n" +
        "<head>\r\n" +
        "    <meta charset=\"UTF-8\">\r\n" +
        "    <style>\r\n" +
        "        .bg{\r\n" +
        "            width: 100%; background: white;\r\n" +
        "        }\r\n" +
        "        .cont{\r\n" +
        "            width: 600px; margin: 0 auto; background: white;\r\n" +
        "        }\r\n" +
        "        .boxCont{\r\n" +
        "            width: 70%; margin: 0 auto;\r\n" +
        "        }\r\n" +
        "        .boxCont p {\r\n" +
        "            font-size: 18px; color: #231f20;\r\n" +
        "        }\r\n" +
        "        .boxCode{\r\n" +
        "            text-align: center; border-radius: 10px; background-color: #7788e7; font-size: 16px; padding: auto;\r\n" +
        "        }\r\n" +
        "        .footer{\r\n" +
        "            font-size: 12px; color: #949595; text-align: center;\r\n" +
        "        }\r\n" +
        "    </style>\r\n" +
        "</head>\r\n" +
        "<body>\r\n" +
        "    <div class=\"bg\">\r\n" +
        "        <div class=\"cont\">\r\n" +
        "            <div class=\"boxCont\">\r\n" +
        "                <p><strong>Estimado usuario,</strong></p>\r\n" +
        "                <p>Su contraseña temporal es: <strong>{password}</strong></p>\r\n" +
        "                <p>Recuerde cambiarla al iniciar sesión.</p>\r\n" +
        "                <p class=\"footer\">Este mensaje de correo electrónico se ha enviado desde una dirección exclusivamente para envíos. No responda a este mensaje.</p>\r\n" +
        "            </div>\r\n" +
        "        </div>\r\n" +
        "    </div>\r\n" +
        "</body>\r\n" +
        "</html>";

}
