package com.pdramirez.restservice.order;



public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Order not found "+id);
    }
}
