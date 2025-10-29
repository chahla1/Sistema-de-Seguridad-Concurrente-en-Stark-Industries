package com.stark.security.securitysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.stark.security.securitysystem.sensores.SensorMovimiento;
import com.stark.security.securitysystem.sensores.SensorTemperatura;
import com.stark.security.securitysystem.sensores.SensorAcceso;

@SpringBootApplication
public class SecuritySystemApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SecuritySystemApplication.class, args);


        SensorMovimiento mov = context.getBean(SensorMovimiento.class);
        SensorTemperatura temp = context.getBean(SensorTemperatura.class);
        SensorAcceso acc = context.getBean(SensorAcceso.class);


        mov.detectar();
        temp.detectar();
        acc.detectar();
    }
}
