package org.gateway.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Copied from https://github.com/Streeling/RD_Archive/blob/main/amsoft/oauth2-login/src/main/java/org/example/config/SecurityConfig.java.
 * See also https://piotrminkowski.com/2024/03/01/microservices-with-spring-cloud-gateway-oauth2-and-keycloak/.
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    http
        .authorizeExchange(authorize -> authorize
            .pathMatchers("/bookstore/service-instances/**").permitAll()
            .anyExchange().authenticated()
        )
        .oauth2Login(withDefaults())
        .oauth2ResourceServer((oauth2) -> oauth2
            .jwt(Customizer.withDefaults())
        );

    return http.build();
  }

  @Bean
  public ReactiveJwtDecoder jwtDecoder() {
    return ReactiveJwtDecoders.fromIssuerLocation("http://localhost:8180/realms/spmia-realm");
  }
}
