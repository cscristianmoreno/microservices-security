package com.microservice.products.interfaces;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface IProductsController {
    Mono<ServerResponse> save(ServerRequest request);

    Mono<ServerResponse> findById(ServerRequest request);
}
