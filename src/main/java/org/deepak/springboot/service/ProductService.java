package org.deepak.springboot.service;

import lombok.Data;
import org.deepak.springboot.model.Product;
import org.deepak.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Data
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }
    public Product addProductWithImage(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getName());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepository.save(product);
    }

    public Product updateProduct( Product product) {
       return productRepository.save(product);
    }

    public void deleteProduct(Integer productId){
        productRepository.deleteById(productId);
    }
}
