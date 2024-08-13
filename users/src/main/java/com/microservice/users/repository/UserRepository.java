package com.microservice.users.repository;

import java.util.Optional;

import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.microservice.users.entity.Users;

import reactor.core.publisher.Mono;

@EnableR2dbcRepositories
public interface UserRepository extends ReactiveCrudRepository<Users, Integer> {
    Mono<Users> findById(int id);

    Mono<Users> findByUsername(String username);
}
