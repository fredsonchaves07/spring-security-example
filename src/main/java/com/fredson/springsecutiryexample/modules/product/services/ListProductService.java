package com.fredson.springsecutiryexample.modules.product.services;

import com.fredson.springsecutiryexample.modules.product.entities.Product;
import com.fredson.springsecutiryexample.modules.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }
}
