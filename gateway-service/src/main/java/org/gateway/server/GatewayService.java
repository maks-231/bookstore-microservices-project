package org.gateway.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import lombok.extern.log4j.Log4j2;

@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
@Log4j2
public class GatewayService {
  public static void main(String[] args) {
    log.info("Gateway server started!");
    SpringApplication.run(GatewayService.class, args);
  }
}
