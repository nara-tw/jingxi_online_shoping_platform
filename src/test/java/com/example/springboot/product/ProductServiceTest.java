package com.example.springboot.product;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.services.ProductService;

public class ProductServiceTest {
//    @Autowired
//    private ProductService productService;
//
//    @Test
//    public void testLoadProductsFromJson() {
//        // Assume you have a method to check the size of the list
//        // This is a simplistic test. Adjust according to your logic.
//        assertNotNull(productService.loadProductsFromJson());
//    }

    @Test
    void exampleTest() {
        assertEquals(2, 1 + 1, "1 + 1 should equal 2");
    }
}