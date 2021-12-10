package com.emard.payementservice.controller;

import java.util.Random;

import com.emard.payementservice.entity.Payment;
import com.emard.payementservice.service.PaymentService;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
@Slf4j
public class PaymentController {
    private final PaymentService service;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        log.info("doPayment [{}]", payment);
        return service.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentByOrderId(@PathVariable Long orderId){
        return service.findPaymentByOrderId(orderId);
    }
    
}
