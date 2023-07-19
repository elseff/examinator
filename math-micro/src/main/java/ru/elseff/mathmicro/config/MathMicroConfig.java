package ru.elseff.mathmicro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class MathMicroConfig {

    @Bean
    @Scope("singleton")
    public Random random(){
        return new Random();
    }
}
