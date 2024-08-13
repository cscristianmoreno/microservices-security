package com.microservice.users.interfaces;

import java.util.Optional;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.microservice.users.entity.Users;

import reactor.core.publisher.Mono;

public interface IUserController {
    Mono<ServerResponse> save(ServerRequest request);

    Mono<ServerResponse> findById(ServerRequest request);

    Mono<ServerResponse> findByUsername(ServerRequest request);

    Mono<ServerResponse> deleteById(ServerRequest request);
}
