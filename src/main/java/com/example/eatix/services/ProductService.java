package com.example.eatix.services;

import com.example.eatix.models.Product;
import com.example.eatix.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProducts() {

        return productRepository.findAll();
    }

    public Product getById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            return productOptional.get();
        }

        throw new RuntimeException("Product with id:" + id + " does not exist!");
    }

    public Product create(Product product) {

        return productRepository.save(product);
    }


    public void delete(long id) {
        productRepository.deleteById(id);
    }

}
