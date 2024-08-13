package com.microservice.users.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table
@Data
public class Users {
    @Id
    private int id;

    private String username;
    private String password;
}
