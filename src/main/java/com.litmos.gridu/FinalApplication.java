package com.litmos.gridu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FinalApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        System.setProperty("server.port", "8000");
        SpringApplication.run(FinalApplication.class, args);
    }
}
