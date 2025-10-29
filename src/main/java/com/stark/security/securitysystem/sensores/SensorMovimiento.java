package com.stark.security.securitysystem.sensores;
import org.springframework.stereotype.Component;

@Component
public class SensorMovimiento extends Sensor {

    public SensorMovimiento() {
        super("S001", "Movimiento");
    }

    @Override
    public void detectar() {
        System.out.println("Detectando movimiento...");
    }
}
