package com.stark.security.securitysystem.sensores;

public class SensorTemperatura extends Sensor {

    public SensorTemperatura(String tipo) {
        super(tipo);
    }

    @Override
    public void detectar() {
        System.out.println("Midiendo temperatura...");
    }
}
