package com.emard.orderservice.service;

import com.emard.orderservice.entity.Order;
import com.emard.orderservice.repository.OrderRepository;
import com.emard.orderservice.request.Payment;
import com.emard.orderservice.request.TransactionRequest;
import com.emard.orderservice.request.TransactionResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository repository;

    private final RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request) {
        log.info("TransactionRequest [{}]",request);
        Order order = request.getOrder();
        order = repository.save(order);
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        // rest call
        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
        String response = paymentResponse.getStatus().equals("success")?"payement processing successful and order placed":"there is a failure!!";
        
        paymentResponse.setOrderId(order.getId());
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
