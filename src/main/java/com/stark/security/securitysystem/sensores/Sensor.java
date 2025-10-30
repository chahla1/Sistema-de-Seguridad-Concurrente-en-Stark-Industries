package com.stark.security.securitysystem.sensores;

public abstract class Sensor {
    private String id;
    private String tipo;

    // 🔹 Constructor con dos parámetros
    public Sensor(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    // 🔹 Nuevo constructor con solo un parámetro (por simplicidad)
    public Sensor(String tipo) {
        this.id = "SENSOR_" + System.currentTimeMillis(); // genera un id automático
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    // método que cada sensor implementará a su manera
    public abstract void detectar();
}
