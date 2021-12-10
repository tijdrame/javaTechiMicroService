package com.emard.orderservice.request;

//import javax.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Long id;
    private String status;
    private String transactionId;
    private Long orderId;
    private Double amount;
    
}
