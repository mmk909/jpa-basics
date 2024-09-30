package com.example.crud.service;

public class ServiceA {

    private final ServiceB serviceB;

    // Constructor injection
    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public String greet() {
        return "ServiceA says: " + serviceB.getMessage();
    }
}
