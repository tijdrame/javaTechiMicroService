package com.emard.cloudgateway.config;

import java.util.logging.Logger;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.stereotype.Component;

//@Component
public class CircuitBreaker implements GatewayFilterFactory{

    private static final Logger log = Logger.getLogger(CircuitBreaker.class.getName());
    @Override
    public GatewayFilter apply(Object config) {
        log.info("IN apply GatewayFilter");
        return null;
    }
    
}
