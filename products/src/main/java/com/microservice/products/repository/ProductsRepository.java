package com.microservice.products.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.microservice.products.entity.Products;

import reactor.core.publisher.Mono;

@EnableR2dbcRepositories
public interface ProductsRepository extends ReactiveCrudRepository<Products, Integer> {
    Mono<Products> findByName(String name);
}
