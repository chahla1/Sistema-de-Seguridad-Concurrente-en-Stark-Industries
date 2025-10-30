package com.stark.security.securitysystem.simulador;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.util.Scanner;

public class SimuladorSensor {

    public static void main(String[] args) throws Exception {

        // URL del servidor WebSocket
        String url = "ws://localhost:8080/ws-alertas";

        // Creamos cliente STOMP sobre WebSocket
        WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        // Creamos handler para recibir mensajes
        StompSessionHandler sessionHandler = new StompSessionHandlerAdapter() {

            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                System.out.println("Conectado al servidor de alertas");

                // Nos suscribimos a /topic/alertas para recibir alertas
                session.subscribe("/topic/alertas", new StompFrameHandler() {
                    @Override
                    public Type getPayloadType(StompHeaders headers) {
                        return String.class; // tipo de mensaje esperado
                    }

                    @Override
                    public void handleFrame(StompHeaders headers, Object payload) {
                        System.out.println("Alerta recibida: " + payload);
                    }
                });
            }
        };

        // Conectamos al servidor y esperamos a que la sesion este lista
        StompSession session = stompClient.connectAsync(url, sessionHandler).get();


        // Permitir al usuario enviar alertas desde la consola
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe alertas (por ejemplo: 'Movimiento detectado') o 'salir' para cerrar:");

        while (true) {
            String mensaje = scanner.nextLine();
            if ("salir".equalsIgnoreCase(mensaje)) break;

            // Enviamos el mensaje al endpoint del servidor
            session.send("/app/alerta", mensaje);
            System.out.println("Alerta enviada: " + mensaje);
        }

        // Cerramos la sesion y el scanner
        session.disconnect();
        scanner.close();
        System.out.println("Simulador desconectado.");
    }
}
