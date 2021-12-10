package com.emard.payementservice.service;

import java.util.Random;
import java.util.UUID;

import com.emard.payementservice.entity.Payment;
import com.emard.payementservice.repository.PaymentRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository repository;

    public Payment doPayment(Payment payment){
        payment.setTransactionId(UUID.randomUUID().toString());
        log.info("doPayment [{}]", payment);
        payment.setStatus(payementProcessing());
        return repository.save(payment);
    }

    public String payementProcessing(){
        return new Random().nextBoolean() ?"success":"false";
    }

    public Payment findPaymentByOrderId(Long orderId) {
        return repository.findByOrderId(orderId);
    }
}
