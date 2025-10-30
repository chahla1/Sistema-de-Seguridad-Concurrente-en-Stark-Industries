package com.stark.security.securitysystem.sensores;

public class SensorAcceso extends Sensor {

    public SensorAcceso(String tipo) {
        super(tipo);
    }

    @Override
    public void detectar() {
        System.out.println("Verificando acceso...");
    }
}
