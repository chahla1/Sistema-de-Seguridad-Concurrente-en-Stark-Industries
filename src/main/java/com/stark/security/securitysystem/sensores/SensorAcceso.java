package com.stark.security.securitysystem.sensores;
import org.springframework.stereotype.Component;

@Component
public class SensorAcceso extends Sensor {

    public SensorAcceso() {
        super("S003", "Acceso");
    }

    @Override
    public void detectar() {
        System.out.println("Verificando acceso...");
    }
}
