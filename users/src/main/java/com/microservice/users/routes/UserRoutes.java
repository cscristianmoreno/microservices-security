package com.microservice.users.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.microservice.users.controller.UserController;

@Configuration
public class UserRoutes {
    
    @Autowired
    private UserController userController;

    @Bean
    @Primary
    RouterFunction<ServerResponse> routes() {

        return RouterFunctions
        .route(
            RequestPredicates.POST("/users/save")
            .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
            userController::save
        )
        .andRoute(RequestPredicates.GET("/users/{id}"), userController::findById);
    }
}
