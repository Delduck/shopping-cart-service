package com.github.delduck.basket.entity;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Product {

    private Long id;
    private String title;
    private BigDecimal price;
    private Integer quantity;

}
