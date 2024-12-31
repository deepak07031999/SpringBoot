package org.deepak.springboot.controller;

import lombok.AllArgsConstructor;
import org.deepak.springboot.model.Product;
import org.deepak.springboot.service.ProductService;
import org.deepak.springboot.service.SearchService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SearchController {

     SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByProductName(@RequestParam("productName") String productName){
       return new ResponseEntity<>(searchService.searchByProductName(productName), HttpStatusCode.valueOf(200));

    }

}
