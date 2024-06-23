package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class ProductController {

    private List<Product> allProducts = loadProductsFromJson();

    @GetMapping("/products")
    public List<Product> listProducts() {
        return allProducts;
    }

    private List<Product> loadProductsFromJson() {
        // Specify the path to your JSON file
        String jsonFilePath = "/Users/naranarawittubtimtoe/Desktop/programming/gs-spring-boot-main/initial/src/main/python/data/products.json";
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = null;

        try {
            // Read the JSON file and convert it into a list of Product objects
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            products = objectMapper.readValue(jsonContent, new TypeReference<List<Product>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    // Product class and other methods
    private static class Product {
        public String id;
        public String name;
        public String description;
        public double price;
        public boolean inStock;
        public String imageUrl;

    }
}