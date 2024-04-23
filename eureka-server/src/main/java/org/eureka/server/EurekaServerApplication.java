package org.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.log4j.Log4j2;

@EnableEurekaServer
@SpringBootApplication
@Log4j2
public class EurekaServerApplication {
    public static void main(String[] args) {
        log.info("EurekaServerApplication started!");
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}