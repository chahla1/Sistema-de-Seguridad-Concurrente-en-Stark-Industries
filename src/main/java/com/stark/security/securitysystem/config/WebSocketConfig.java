package com.stark.security.securitysystem.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint para que los clientes puedan conectarse
        registry.addEndpoint("/ws-alertas");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // prefijo para los mensajes que se envian cliente-servidor
        registry.setApplicationDestinationPrefixes("/app");
        // prefijo para los mensajes enviados servidor-cliente
        registry.enableSimpleBroker("/topic");
    }
}
