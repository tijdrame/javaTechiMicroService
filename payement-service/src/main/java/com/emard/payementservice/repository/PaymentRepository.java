package com.emard.payementservice.repository;

import com.emard.payementservice.entity.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

    Payment findByOrderId(Long orderId);
    
}
