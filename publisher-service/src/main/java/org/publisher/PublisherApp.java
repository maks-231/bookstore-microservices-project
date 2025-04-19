package org.publisher;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@Log4j2
public class PublisherApp {
    public static void main(String[] args) {
        SpringApplication.run(PublisherApp.class, args);
    }
}
