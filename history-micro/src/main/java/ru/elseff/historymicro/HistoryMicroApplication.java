package ru.elseff.historymicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HistoryMicroApplication {
    public static void main(String[] args) {
        SpringApplication.run(HistoryMicroApplication.class, args);
    }
}
