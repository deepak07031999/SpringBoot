package org.deepak.springboot.service;

import org.deepak.springboot.model.Product;
import org.deepak.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class SearchService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> searchByProductName(String name) {
        return productRepository.findByNameContainsIgnoreCase(name);
    }
}
