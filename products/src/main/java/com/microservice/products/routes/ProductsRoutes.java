package com.microservice.products.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.microservice.products.controller.ProductsController;

@Configuration
public class ProductsRoutes {
    
    private final ProductsController productsController;

    public ProductsRoutes(final ProductsController productsController) {
        this.productsController = productsController;
    }
    
    @Bean
    RouterFunction<ServerResponse> routes() {
        return RouterFunctions
        .route(POST("/products/save").and(accept(MediaType.APPLICATION_JSON)), productsController::save)
        .andRoute(GET("/products/{id}"), productsController::findById);
    }
}
