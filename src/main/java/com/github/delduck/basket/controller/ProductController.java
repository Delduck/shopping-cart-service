package com.github.delduck.basket.controller;

import com.github.delduck.basket.client.response.FakeStoreProductResponse;
import com.github.delduck.basket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<FakeStoreProductResponse>> getAllProducts() {
        List<FakeStoreProductResponse> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FakeStoreProductResponse> getProductById(@PathVariable Long id) {
        FakeStoreProductResponse productById = productService.getProductById(id);
        return ResponseEntity.ok(productById);
    }

}
