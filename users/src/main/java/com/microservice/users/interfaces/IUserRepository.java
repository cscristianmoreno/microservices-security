package com.microservice.users.interfaces;

import java.util.Optional;

import com.microservice.users.entity.Users;

import reactor.core.publisher.Mono;

public interface IUserRepository {
    Mono<Users> save(Users request);

    Mono<Users> findById(int id);

    Mono<Users> findByUsername(String username);

    Mono<Void> deleteById(int id);
}
