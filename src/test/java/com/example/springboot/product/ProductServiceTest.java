package com.example.springboot.product;

import com.example.springboot.exceptions.CustomIOException;
import com.example.springboot.model.Product;
import com.example.springboot.services.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ObjectMapper objectMapper;

    private ProductService productService;

        private final String jsonStub = "[{\"id\":\"2c46f8d2-5fa9-445a-8078-09bd5b7c8f12\",\"name\":\"Exist\",\"description\":\"Good past impact method right cell. Evening box third stay information. Anything successful new raise board.\",\"price\":495.88,\"inStock\":true,\"imageUrl\":\"https://dummyimage.com/828x202\"},{\"id\":\"de6873f4-39c3-463c-9cac-4963dd76a00c\",\"name\":\"Involve\",\"description\":\"Do evening notice key everyone stage. Rate sign unit.\\nIssue go someone cover company. National trial television attention.\",\"price\":63.74,\"inStock\":false,\"imageUrl\":\"https://dummyimage.com/586x356\"}]";


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(objectMapper) {
            @Override
            protected String readFileContent(String filePath) {
                return jsonStub;
            }
        };
    }

    @Test
    void loadProductsFromJson_Success() throws Exception {
        when(objectMapper.readValue(anyString(), any(TypeReference.class))).thenReturn(List.of(new Product()));
        
        List<Product> products = productService.loadProductsFromJson();
        
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

    @Test
    void loadProductsFromJson_FailToReadFile() {
        productService = new ProductService(objectMapper) {
            @Override
            protected String readFileContent(String filePath) throws CustomIOException {
                throw new CustomIOException("Failed to read file", new IOException());
            }
        };

        assertThrows(CustomIOException.class, () -> productService.loadProductsFromJson());
    }
}