package com.stark.security.securitysystem;
import com.stark.security.securitysystem.sensores.*;
import com.stark.security.securitysystem.services.SensorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private SensorService sensorService;

    @Override
    public void run(String... args) throws Exception {
        Sensor movimiento = new SensorMovimiento("Sensor de Movimiento");
        Sensor temperatura = new SensorTemperatura("Sensor de Temperatura");
        Sensor acceso = new SensorAcceso("Sensor de Acceso");

        sensorService.procesarSensor(movimiento);
        sensorService.procesarSensor(temperatura);
        sensorService.procesarSensor(acceso);

        System.out.println("Sensores en ejecucion concurrente...");
    }
}
