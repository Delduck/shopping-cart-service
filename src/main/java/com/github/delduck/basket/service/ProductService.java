package com.github.delduck.basket.service;

import com.github.delduck.basket.client.FakeStoreAPIClient;
import com.github.delduck.basket.client.response.FakeStoreProductResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final FakeStoreAPIClient fakeStoreAPIClient;

    public List<FakeStoreProductResponse> getAllProducts() {
        return fakeStoreAPIClient.getAllProducts();
    }

    public FakeStoreProductResponse getProductById(Long id) {
        return fakeStoreAPIClient.getProductById(id);
    }
}
