package com.emard.orderservice.controller;

import com.emard.orderservice.request.TransactionRequest;
import com.emard.orderservice.request.TransactionResponse;
import com.emard.orderservice.service.OrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){
        
        return service.saveOrder(request);
    }
}
