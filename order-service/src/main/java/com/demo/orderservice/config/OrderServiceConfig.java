package com.demo.orderservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OrderServiceConfig {

    @Value("${inventory.service.base.url}")
    private String inventoryBasePath;

   @Bean
    WebClient inventoryClient(){
        return WebClient.builder().baseUrl(inventoryBasePath).build();
    }
}
