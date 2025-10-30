package com.stark.security.securitysystem.simulador;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class SimuladorSensor {

    public static void main(String[] args) throws Exception {
        // Configuramos el cliente STOMP sobre SockJS
        List<Transport> transports = List.of(new WebSocketTransport(new StandardWebSocketClient()));
        SockJsClient sockJsClient = new SockJsClient(transports);
        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);

        // Conectamos al servidor
        String url = "ws://localhost:8081/alertas";
        StompSessionHandlerAdapter handler = new StompSessionHandlerAdapter() {};
        CompletableFuture<StompSession> futureSession = stompClient.connectAsync(url, handler);
        StompSession session = futureSession.get();

        System.out.println("Sensor conectado al servidor.");

        // Suscribirse a recibir alertas en tiempo real
        session.subscribe("/topic/alertas", new StompFrameHandler() {
            @Override
            public Type getPayloadType(StompHeaders headers) {
                return String.class; // los mensajes son Strings
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                String mensaje = (String) payload;
                System.out.println("Alerta recibida: " + mensaje);
            }
        });

        // Enviar alertas desde la consola
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe mensajes de alerta y pulsa ENTER (escribe 'salir' para terminar):");
        while (true) {
            String mensaje = scanner.nextLine();
            if ("salir".equalsIgnoreCase(mensaje)) break;
            session.send("/app/alerta", mensaje);
            System.out.println("Alerta enviada: " + mensaje);
        }

        scanner.close();
        session.disconnect();
        System.out.println("Sensor desconectado.");
    }
}
