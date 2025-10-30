package com.stark.security.securitysystem.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Primero definimos los usuarios y roles
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        UserDetails guardia = User.withDefaultPasswordEncoder()
                .username("guest")
                .password("guest123")
                .roles("GUEST")
                .build();

        return new InMemoryUserDetailsManager(admin, guardia);
    }

    // despues vamos a configuramos las reglas de acceso
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // cualquier URL requiere login
                )
                .formLogin(Customizer.withDefaults()) // activa el login
                .httpBasic(Customizer.withDefaults()); // permite autenticacion basica
        return http.build();
    }
}

