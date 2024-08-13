package com.microservice.products.services;

import org.springframework.stereotype.Service;

import com.microservice.products.entity.Products;
import com.microservice.products.interfaces.IProductsRepositoryService;
import com.microservice.products.repository.ProductsRepository;

import reactor.core.publisher.Mono;

@Service
public class ProductsRepositoryService implements IProductsRepositoryService {
    
    private final ProductsRepository productsRepository;

    public ProductsRepositoryService(final ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public Mono<Products> save(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Mono<Products> findById(int id) {
        return productsRepository.findById(id);
    }
}
