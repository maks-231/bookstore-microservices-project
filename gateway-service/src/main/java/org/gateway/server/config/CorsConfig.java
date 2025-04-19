package org.gateway.server.config;


import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.ServerWebExchange;


import java.util.List;
import java.util.function.Function;

@Configuration
public class CorsConfig {
//    @Bean
//    public WebFilter corsFilter() {
//        return (ServerWebExchange exchange, WebFilterChain chain) -> {
//            exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "http://localhost:4200");
//            exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "http://127.0.0.1:4200");
//            exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
//            return chain.filter(exchange);
//        };
//    }
//    @Bean
//    Function<GatewayFilterSpec, UriSpec> brutalCorsFilters() {
//        return f -> f
//                .setResponseHeader("Access-Control-Allow-Origin", "*")
//                .setResponseHeader("Access-Control-Allow-Methods", "*")
//                .setResponseHeader("Access-Control-Expose-Headers", "*");
//    }
}
