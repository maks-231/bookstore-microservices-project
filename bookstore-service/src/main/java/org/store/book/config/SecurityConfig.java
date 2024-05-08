package org.store.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Copied from https://github.com/Streeling/RD_Archive/blob/main/amsoft/oauth2-resource-server/src/main/java/org/example/config/SecurityConfig.java.
 * See also https://piotrminkowski.com/2024/03/01/microservices-with-spring-cloud-gateway-oauth2-and-keycloak/.
 */
//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authorize) -> authorize
            .requestMatchers("/service-instances/**").anonymous()
            .requestMatchers("/error/**").anonymous()
            .anyRequest().authenticated()
        )
        .oauth2ResourceServer((oauth2) -> oauth2
            .jwt(Customizer.withDefaults())
        );
    return http.build();
  }

  @Bean
  public JwtDecoder jwtDecoder() {
    return JwtDecoders.fromIssuerLocation("http://localhost:8180/realms/spmia-realm");
  }
}