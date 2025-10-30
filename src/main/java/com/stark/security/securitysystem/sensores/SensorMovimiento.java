package com.stark.security.securitysystem.sensores;

public class SensorMovimiento extends Sensor {

    // Constructor que recibe el tipo
    public SensorMovimiento(String tipo) {
        super(tipo);
    }

    @Override
    public void detectar() {
        System.out.println("Detectando movimiento...");
    }
}
