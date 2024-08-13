package com.microservice.products.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table
@Data
public class Products {
    @Id
    private int id;
    private String name;
    private int price;
}
