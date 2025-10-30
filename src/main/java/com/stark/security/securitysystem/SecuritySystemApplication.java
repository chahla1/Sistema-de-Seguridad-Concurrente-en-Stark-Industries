package com.stark.security.securitysystem;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.stark.security.securitysystem.sensores.SensorMovimiento;
import com.stark.security.securitysystem.sensores.SensorTemperatura;
import com.stark.security.securitysystem.sensores.SensorAcceso;
import com.stark.security.securitysystem.services.SensorService;

@EnableAsync
@SpringBootApplication
public class SecuritySystemApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SecuritySystemApplication.class, args);


        SensorMovimiento mov = context.getBean(SensorMovimiento.class);
        SensorTemperatura temp = context.getBean(SensorTemperatura.class);
        SensorAcceso acc = context.getBean(SensorAcceso.class);

        SensorService service = context.getBean(SensorService.class);

        // Llamamos a los sensores en paralelo
        service.procesarSensor(mov);
        service.procesarSensor(temp);
        service.procesarSensor(acc);

        System.out.println("Todos los sensores estan procesandose en paralelo...");

    }
}
