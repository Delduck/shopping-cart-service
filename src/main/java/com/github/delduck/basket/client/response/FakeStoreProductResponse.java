package com.github.delduck.basket.client.response;

import java.math.BigDecimal;

public record FakeStoreProductResponse(Long id, String title, BigDecimal price) {
}