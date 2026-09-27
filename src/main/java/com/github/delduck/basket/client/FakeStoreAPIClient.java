package com.github.delduck.basket.client;

import com.github.delduck.basket.client.response.FakeStoreProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "FakeStoreAPIClient", url = "${basket.client.fakestoreapi}")
public interface FakeStoreAPIClient {

    @GetMapping("/products")
    List<FakeStoreProductResponse> getAllProducts();

    @GetMapping("/products/{id}")
    FakeStoreProductResponse getProductById(@PathVariable Long id);

}
