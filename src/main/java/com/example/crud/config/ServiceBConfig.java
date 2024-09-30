package com.example.crud.config;


import com.example.crud.service.ServiceB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBConfig {

    @Bean
    public ServiceB haha() {
        return new ServiceB();
    }
}
