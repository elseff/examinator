package ru.elseff.discoverymicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryMicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryMicroApplication.class, args);
    }

}
