package com.example.springboot;

import com.example.springboot.exceptions.CustomIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Product;
import com.example.springboot.services.ProductService;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> listProducts() throws CustomIOException {
        return productService.loadProductsFromJson();
    }
}