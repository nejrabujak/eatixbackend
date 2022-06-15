package com.example.eatix.controllers;

import com.example.eatix.models.Product;
import com.example.eatix.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping
    public List<Product> getProducts() {

        return productService.getProducts();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) {
        return productService.getById(id);
    }

    @CrossOrigin
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        productService.delete(id);
    }
}