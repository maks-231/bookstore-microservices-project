package org.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationService {
  public static void main(String[] args) {
    System.out.println("Configuration server started!");
    SpringApplication.run(ConfigurationService.class, args);
  }
}