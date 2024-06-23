package com.example.springboot.services;

import com.example.springboot.exceptions.CustomIOException;
import com.example.springboot.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
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

    private final ObjectMapper objectMapper;

    @Autowired
    public ProductService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Product> loadProductsFromJson() throws CustomIOException {
        String jsonContent = readFileContent(jsonFilePath);
        try {
            return objectMapper.readValue(jsonContent, new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            throw new CustomIOException("Failed to parse JSON", e);
        }
    }

    protected String readFileContent(String filePath) throws CustomIOException {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new CustomIOException("Failed to read file", e);
        }
    }
}