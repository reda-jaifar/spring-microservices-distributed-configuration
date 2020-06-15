package com.rj.api.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

  @Bean
  public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    return builder.routes()
            .route(r -> r.path("/orders/**")
                    .uri("lb://ORDER-SERVICE")
                    .id("order-service"))

            .route(r -> r.path("/spares/**")
                    .uri("lb://SPARE-SERVICE")
                    .id("spare-service"))
            .build();
  }
}
