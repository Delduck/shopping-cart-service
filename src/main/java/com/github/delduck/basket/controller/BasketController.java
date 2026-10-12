package com.github.delduck.basket.controller;

import com.github.delduck.basket.controller.request.BasketRequest;
import com.github.delduck.basket.entity.Basket;
import com.github.delduck.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping
    public ResponseEntity<Basket> createBasket(@RequestBody BasketRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(basketService.createBasket(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable String id) {
        return ResponseEntity.ok(basketService.getBasketById(id));
    }


}
