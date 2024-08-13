package com.microservice.gateway.gateway;

import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservice.gateway.filter.CustomGatewayFilter;

@Configuration
public class GatewayConfig {
    
    @Bean
    AbstractGatewayFilterFactory<CustomGatewayFilter> filterConfig() {
        return new CustomGatewayFilter();
    }
}
