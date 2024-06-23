package com.example.springboot.services;

import com.example.springboot.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProductService {

    @Value("${product.json.filepath}")
    private String jsonFilePath;

    public List<Product> loadProductsFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = null;

        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            products = objectMapper.readValue(jsonContent, new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            // Consider logging the error and potentially throwing a custom exception
            e.printStackTrace();
        }

        return products;
    }
}