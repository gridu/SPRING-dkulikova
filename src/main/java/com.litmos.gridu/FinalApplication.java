package com.litmos.gridu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalApplication {
    public static void main(String[] args) {
        System.setProperty("server.port", "8000");
        SpringApplication.run(FinalApplication.class, args);
    }
}
