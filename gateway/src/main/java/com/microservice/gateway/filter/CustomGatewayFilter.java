package com.microservice.gateway.filter;

import java.util.List;

import org.apache.hc.core5.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;

public class CustomGatewayFilter extends AbstractGatewayFilterFactory<CustomGatewayFilter> {
    
    @Value("${x_secret_key}")
    private String secretKey;

    @Value("${x_secret_authorization}")
    private String secretAuthorization;

    public CustomGatewayFilter() {
        super(CustomGatewayFilter.class);
    }

    static class Config {
    }

    @Override
    public GatewayFilter apply(CustomGatewayFilter config) {
        return (exchange, chain) -> {
            System.out.println(secretKey);

            exchange.mutate().request(
                exchange.getRequest().mutate().header(secretAuthorization, secretKey).build()
            ).build();
            return chain.filter(exchange);
        };
    }
}
