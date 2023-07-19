package ru.elseff.mathmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MathMicroApplication {
    public static void main(String[] args) {
        SpringApplication.run(MathMicroApplication.class, args);
    }
}
