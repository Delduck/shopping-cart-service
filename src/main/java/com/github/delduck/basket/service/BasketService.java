package com.github.delduck.basket.service;

import com.github.delduck.basket.client.response.FakeStoreProductResponse;
import com.github.delduck.basket.controller.request.BasketRequest;
import com.github.delduck.basket.controller.request.PaymentRequest;
import com.github.delduck.basket.entity.Basket;
import com.github.delduck.basket.entity.Product;
import com.github.delduck.basket.entity.Status;
import com.github.delduck.basket.exceptions.BusinessException;
import com.github.delduck.basket.exceptions.DataNotFoundException;
import com.github.delduck.basket.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;

    public Basket getBasketById(String idBasket) {
        return basketRepository.findById(idBasket)
                .orElseThrow(() -> new DataNotFoundException("Basket not found"));
    }

    public Basket createBasket(BasketRequest basketRequest) {

        basketRepository.findByClientAndStatus(basketRequest.clientId(), Status.OPEN)
                .ifPresent(basket -> {
                    throw new BusinessException("There is already an open basket for this client");
                });

        List<Product> products = getProducts(basketRequest);

        Basket basket = Basket.builder()
                .client(basketRequest.clientId())
                .status(Status.OPEN)
                .products(products)
                .build();

        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }

    public Basket updateBasketById(String idBasket, BasketRequest basketRequest) {
        Basket savedBasket = getBasketById(idBasket);

        if (savedBasket.getStatus() != Status.OPEN) {
            throw new BusinessException("Only open baskets can be updated");
        }

        List<Product> products = getProducts(basketRequest);

        savedBasket.setProducts(products);
        savedBasket.calculateTotalPrice();

        return basketRepository.save(savedBasket);

    }

    public Basket payBasket(String idBasket, PaymentRequest paymentRequest) {
        Basket savedBasket = getBasketById(idBasket);
        savedBasket.setPaymentMethod(paymentRequest.paymentMethod());
        savedBasket.setStatus(Status.SOLD);
        return basketRepository.save(savedBasket);
    }

    public void deleteBasket(String idBasket) {
        Basket savedBasket = getBasketById(idBasket);
        basketRepository.deleteById(savedBasket.getId());
    }

    private List<Product> getProducts(BasketRequest basketRequest) {
        return basketRequest.products().stream()
                .map(productRequest -> {
                    FakeStoreProductResponse productByIdResponse = productService.getProductById(productRequest.id());

                    return Product.builder()
                            .id(productByIdResponse.id())
                            .title(productByIdResponse.title())
                            .price(productByIdResponse.price())
                            .quantity(productRequest.quantity())
                            .build();
                })
                .toList();
    }
}
