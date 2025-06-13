package com.example.EcommerceBackJem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EcommerceBackJemApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceBackJemApplication.class, args);
    }
}
