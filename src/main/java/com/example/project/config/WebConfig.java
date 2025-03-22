package com.example.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Accepte toutes les routes
                .allowedOrigins(
                        "http://192.168.1.108:3000",
                        "http://localhost:3000"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permet les méthodes courantes
                .allowedHeaders("*") // Autorise tous les headers
                .allowCredentials(true) // Autorise les cookies/sessions si besoin
                .maxAge(3600);
    }

}
