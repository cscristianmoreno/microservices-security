package com.microservice.users.controller;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.microservice.users.entity.Users;
import com.microservice.users.interfaces.IUserController;
import com.microservice.users.services.UserRepositoryService;

import reactor.core.publisher.Mono;

@Component
public class UserController implements IUserController {

    private final UserRepositoryService userRepositoryService;

    public UserController(final UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    @Override
    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(Users.class).flatMap((users) -> {
            return userRepositoryService.save(users);
        })
        .flatMap((result) -> ServerResponse.ok().bodyValue(result));
    }

    @Override
    public Mono<ServerResponse> findById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return userRepositoryService.findById(id)
        .flatMap((result) -> {
            return ServerResponse.ok().bodyValue(result);
        })
        .switchIfEmpty(ServerResponse.notFound().build());
    }

    @Override
    public Mono<ServerResponse> findByUsername(ServerRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }

    @Override
    public Mono<ServerResponse> deleteById(ServerRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
