package com.example.microservice1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Value("${message}")
    private String message;

    @GetMapping("/hello")
    public String getMessage() {
        return message;
    }
}
