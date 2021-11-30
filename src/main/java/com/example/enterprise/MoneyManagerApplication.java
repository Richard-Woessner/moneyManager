package com.example.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MoneyManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneyManagerApplication.class, args);
    }

}
