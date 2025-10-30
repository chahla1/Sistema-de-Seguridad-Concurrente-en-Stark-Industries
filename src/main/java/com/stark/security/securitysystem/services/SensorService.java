package com.stark.security.securitysystem.services;
import com.stark.security.securitysystem.sensores.Sensor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
//Clase para que los sensores trabajen en paralelo
@Service
public class SensorService {

    // Metodo que procesa los datos del sensor de forma concurrente
    @Async
    public void procesarSensor(Sensor sensor) {
        System.out.println("Procesando sensor: " + sensor.getTipo() + " en hilo " + Thread.currentThread().getName());
        sensor.detectar();

        try {
            // Simulamos que tarda en procesar (3 segundos)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finalizado sensor: " + sensor.getTipo());
    }

}

