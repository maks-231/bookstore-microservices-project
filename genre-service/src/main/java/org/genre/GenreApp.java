package org.genre;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@Log4j2
public class GenreApp {
    public static void main(String[] args) {
        SpringApplication.run(GenreApp.class, args);
    }
}
