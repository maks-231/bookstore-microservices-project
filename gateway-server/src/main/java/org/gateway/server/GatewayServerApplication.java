package org.gateway.server;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import lombok.extern.log4j.Log4j2;

@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
@Log4j2
public class GatewayServerApplication {
  public static void main(String[] args) {
    log.info("Gateway server started!");
    new SpringApplicationBuilder(GatewayServerApplication.class)
        .web(WebApplicationType.REACTIVE)
        .run(args);
  }
}
