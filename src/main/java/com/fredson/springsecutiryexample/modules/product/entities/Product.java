package com.fredson.springsecutiryexample.modules.product.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
