package com.emard.orderservice.request;

import com.emard.orderservice.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    
    private Order order;
    private Double  amount;
    private String transactionId;
    private String message;
}
