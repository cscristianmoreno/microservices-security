package com.microservice.users.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservice.users.entity.Users;
import com.microservice.users.interfaces.IUserRepository;
import com.microservice.users.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserRepositoryService implements IUserRepository {

    public final UserRepository userRepository;

    public UserRepositoryService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<Users> save(Users request) {
        return userRepository.save(request);
    }

    @Override
    public Mono<Users> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Mono<Void> deleteById(int id) {
        userRepository.deleteById(id);
        return Mono.empty();
    }
}
