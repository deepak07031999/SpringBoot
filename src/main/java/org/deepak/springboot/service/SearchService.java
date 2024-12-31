package org.deepak.springboot.service;

import org.deepak.springboot.model.Product;
import org.deepak.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> searchByProductName(String name) {
        return productRepository.findByNameContainsIgnoreCase(name);
    }
}
