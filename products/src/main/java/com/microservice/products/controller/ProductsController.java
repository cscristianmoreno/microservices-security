package com.microservice.products.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.microservice.products.entity.Products;
import com.microservice.products.interfaces.IProductsController;
import com.microservice.products.services.ProductsRepositoryService;

import reactor.core.publisher.Mono;

@Component
public class ProductsController implements IProductsController {
    private final ProductsRepositoryService productsRepositoryService;

    public ProductsController(final ProductsRepositoryService productsRepositoryService) {
        this.productsRepositoryService = productsRepositoryService;
    }

    @Override
    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(Products.class)
        .flatMap((result) -> productsRepositoryService.save(result))
        .flatMap((result) -> ServerResponse.ok().bodyValue(result));
    }

    @Override
    public Mono<ServerResponse> findById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return productsRepositoryService.findById(id)
        .flatMap((result) -> ServerResponse.ok().bodyValue(result))
        .switchIfEmpty(ServerResponse.badRequest().build());
    }
    
}
