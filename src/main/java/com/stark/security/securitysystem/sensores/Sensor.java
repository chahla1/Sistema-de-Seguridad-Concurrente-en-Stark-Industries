package com.stark.security.securitysystem.sensores;

public abstract class Sensor {
    private String id;
    private String tipo;

    public Sensor(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    // metodo que cada sensor va a implementar a su manera
    public abstract void detectar();
}