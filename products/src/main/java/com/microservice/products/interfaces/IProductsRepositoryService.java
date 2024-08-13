package com.microservice.products.interfaces;

import com.microservice.products.entity.Products;

import reactor.core.publisher.Mono;

public interface IProductsRepositoryService {
    Mono<Products> save(Products products);

    Mono<Products> findById(int id);
}
