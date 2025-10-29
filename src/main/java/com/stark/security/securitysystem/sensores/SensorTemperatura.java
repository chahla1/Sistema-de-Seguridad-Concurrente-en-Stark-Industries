package com.stark.security.securitysystem.sensores;
import org.springframework.stereotype.Component;

@Component
public class SensorTemperatura extends Sensor {

    public SensorTemperatura() {
        super("S002", "Temperatura");
    }

    @Override
    public void detectar() {
        System.out.println("Midiendo temperatura...");
    }
}
