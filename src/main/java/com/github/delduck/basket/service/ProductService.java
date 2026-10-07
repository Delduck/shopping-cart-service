package com.github.delduck.basket.service;

import com.github.delduck.basket.client.FakeStoreAPIClient;
import com.github.delduck.basket.client.response.FakeStoreProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final FakeStoreAPIClient fakeStoreAPIClient;

    @Cacheable(value = "products")
    public List<FakeStoreProductResponse> getAllProducts() {
        log.info("Getting all products");
        return fakeStoreAPIClient.getAllProducts();
    }

    @Cacheable(value = "product", key = "#productId")
    public FakeStoreProductResponse getProductById(Long productId) {
        log.info("Getting product with id: {}", productId);
        return fakeStoreAPIClient.getProductById(productId);
    }
}
