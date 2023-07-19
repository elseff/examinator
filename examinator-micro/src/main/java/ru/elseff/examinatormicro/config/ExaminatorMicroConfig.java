package ru.elseff.examinatormicro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ExaminatorMicroConfig {

    @Bean
    @Scope("singleton")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
