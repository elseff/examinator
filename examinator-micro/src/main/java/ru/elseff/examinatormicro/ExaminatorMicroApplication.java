package ru.elseff.examinatormicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExaminatorMicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExaminatorMicroApplication.class, args);
    }

}
