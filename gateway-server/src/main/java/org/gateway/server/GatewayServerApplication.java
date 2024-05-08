package org.gateway.server;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
@RestController
@Log4j2
public class GatewayServerApplication {
  public static void main(String[] args) {
    log.info("Gateway server started!");
    new SpringApplicationBuilder(GatewayServerApplication.class)
        .web(WebApplicationType.REACTIVE)
        .run(args);
  }

  @GetMapping(value = "/token")
  public Mono<String> getHome(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
    return Mono.just(authorizedClient.getAccessToken().getTokenValue());
  }
}
