package com.example.crud.config;

import com.example.crud.service.ServiceA;
import com.example.crud.service.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class ServiceAConfig {

    private final ServiceB serviceB;

    @Autowired
    public ServiceAConfig(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    @Bean
    public ServiceA serviceA() {
        return new ServiceA(serviceB);
    }
}
