package com.github.delduck.basket.controller.request;

import com.github.delduck.basket.entity.PaymentMethod;

public record PaymentRequest (PaymentMethod paymentMethod){}
