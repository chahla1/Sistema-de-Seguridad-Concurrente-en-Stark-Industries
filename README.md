# Sistema de Seguridad Concurrente - Stark Industries

## Integrantes
- Chahla (Backend y simulador)

## Descripción
Este proyecto implementa un sistema concurrente para la detección de intrusiones en tiempo real.
Utiliza sensores simulados que generan y envían alertas a través de WebSockets, permitiendo una 
distribución eficiente y en tiempo real de las notificaciones a los suscriptores conectados. 
El sistema está diseñado para simular un entorno de seguridad, como el de Stark Industries, 
donde la concurrencia y la rapidez en la respuesta son críticas.

## Estructura principal
- `SimuladorSensor.java`: Cliente que envía alertas de sensores.
- `AlertaController.java`: Recibe y distribuye alertas a los suscriptores.
- `SecurityConfig.java`: Configuración de seguridad.
- `application.properties`: Configuración general del servidor.

## Tecnologías Utilizadas
- Java: Lenguaje principal para el desarrollo del backend y simulador.
- Spring Boot: Framework para el servidor web y gestión de WebSockets.
- WebSockets: Protocolo para comunicación bidireccional en tiempo real.
- Maven: Herramienta de gestión de dependencias y construcción del proyecto.

## Ejecución
1. Ejecutar el servidor Spring Boot (`mvn spring-boot:run`).
2. Ejecutar el simulador (`SimuladorSensor`).
3. Abrir `http://localhost:8080` y observar las alertas en tiempo real.
