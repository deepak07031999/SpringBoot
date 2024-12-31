package org.deepak.springboot.controller;

import lombok.AllArgsConstructor;
import org.deepak.springboot.model.Product;
import org.deepak.springboot.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.valueOf(200));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);
        if(product==null) {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
        return new ResponseEntity<>(product,HttpStatus.valueOf(200));
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);
        if(product==null) {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(product.getImageData());
//        (product.getImageData(),HttpStatus.valueOf(200));
    }

    @GetMapping("/product/")
    public ResponseEntity<Product> getProductByQueryParam(@RequestParam("id") String productId){
        return new ResponseEntity<>(productService.getProductById(parseInt(productId)),HttpStatus.valueOf(200));
    }

    @PostMapping("/product/add")
    public ResponseEntity<String> addProduct( @RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<>( "Product Added successfully",HttpStatus.valueOf(200));
    }

//    @PostMapping("/product/add")
//    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
//        try{
//            return new ResponseEntity<>(productService.addProductWithImage(product, imageFile), HttpStatus.valueOf(200));
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.valueOf(500));
//        }
//    }

    @DeleteMapping("/product/{productId}")
    public String deleteProduct( @PathVariable Integer productId){
        productService.deleteProduct(productId);
        return "Product deleted Successfully";
    }

    @PutMapping("/product/")
    public String updateProduct( @RequestBody Product product){
        productService.updateProduct(product);
        return "Product deleted Successfully";
    }

}
