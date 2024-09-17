package com.example.CostenoBackend.Infra;

public class MessageHTML {
    
    public static final String TEMPLATE_PRUEBA = "<html lang=\"en\">\r\n" + //
                "<head>\r\n" + //
                "    <meta charset=\"UTF-8\">\r\n" + //
                "    <style>\r\n" + //
                "        .bg{\r\n" + //
                "            width: 100%; background: white;\r\n" + //
                "        }\r\n" + //
                "        .cont{\r\n" + //
                "            width: 600px; margin: 0 auto; background: white; \r\n" + //
                "        }\r\n" + //
                "        .boxCont{\r\n" + //
                "            width: 70%; margin: 0 auto;\r\n" + //
                "        }\r\n" + //
                "        .boxCont p {\r\n" + //
                "            font-size: 18px; color: #231f20;\r\n" + //
                "        }\r\n" + //
                "        .boxCode{\r\n" + //
                "            text-align: center; border-radius: 10px; background-color: #7788e7; font-size: 16px; padding: auto;\r\n" + //
                "        }\r\n" + //
                "        .boxCode{\r\n" + //
                "            width: 12%; height: 40px; font-size: 16px; display: inline-block; border-bottom: 1px #fff solid; border-radius: 5px; text-align: center;\r\n" + //
                "            font-size: 32px; margin-left: 5px; color: #fff; \r\n" + //
                "        }\r\n" + //
                "        .boxCont .footer{\r\n" + //
                "            font-size: 12px; color: #949595; text-align: center;\r\n" + //
                "        }\r\n" + //
                "        .cont .fo{\r\n" + //
                "            width: 100%;\r\n" + //
                "            height: 10px;\r\n" + //
                "            margin: 20px 0 0 0;\r\n" + //
                "            background: linear-gradient(90deg, #4155c4, #1b04a1);\r\n" + //
                "        }\r\n" + //
                "    </style>\r\n" + //
                "</head>\r\n" + //
                "<body>\r\n" + //
                "    <div class=\"bg\">\r\n" + //
                "        <div class=\"cont\">\r\n" + //
                "            <div class=\"boxCont\">\r\n" + //
                "                <p> <strong>Estimado usuario</strong>,</p>\r\n" + //
                "                <p>Su codigo de verificacion para el inicio de sesion es: </p>\r\n" + //
                "                <div class=\"boxCode\">\r\n" + //
                "                    <p>{0}</p>\r\n" + //
                "                    <p>{1}</p>\r\n" + //
                "                    <p>{2}</p>\r\n" + //
                "                    <p>{3}</p>\r\n" + //
                "                    <p>{4}</p>\r\n" + //
                "                    <p>{5}</p>\r\n" + //
                "                </div>\r\n" + //
                "                <p>Este codigo es de un solo uso.</p>\r\n" + //
                "                <br>\r\n" + //
                "                <p class=\"footer\">Este mensaje de correo electronico se ha enviado desde una \r\n" + //
                "                    direccion exclusivamente para envios. No responda a este mensaje</p>\r\n" + //
                "            </div>\r\n" + //
                "        </div>\r\n" + //
                "    </div>\r\n" + //
                "</body>\r\n" + //
                "</html>";
}
