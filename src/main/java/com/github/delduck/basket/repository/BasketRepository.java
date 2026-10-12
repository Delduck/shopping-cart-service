package com.github.delduck.basket.repository;

import com.github.delduck.basket.entity.Basket;
import com.github.delduck.basket.entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends MongoRepository<Basket, String> {

    Optional<Basket> findByClientAndStatus(Long clienteId, Status status);
}
