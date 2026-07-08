package com.customerdetails.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
    @RequestMapping("/api")
    public class HealthController {

        @GetMapping("/health")
        public String health() {
            return "Application is running";
        }
    }

