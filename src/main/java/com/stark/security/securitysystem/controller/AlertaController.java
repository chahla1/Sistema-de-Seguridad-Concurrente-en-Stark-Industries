package com.stark.security.securitysystem.controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class AlertaController {

    // esto hace que cuando un sensor envia una alarma les llegue a los clientes conectados
    @MessageMapping("/alerta")
    @SendTo("/topic/alertas")
    public String enviarAlerta(String mensaje) {
        System.out.println(" Alerta recibida: " + mensaje);
        return "ALERTA: " + mensaje;
    }
}
