package com.customerdetails.controller;

import com.customerdetails.dto.CustomerRequestDto;
import com.customerdetails.dto.CustomerResponseDto;
import com.customerdetails.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    private final CustomerService customerService;



    @PostMapping("/customer")
    public ResponseEntity<CustomerResponseDto> addNewCustomer(
            @RequestBody CustomerRequestDto customerRequestDto) {

        CustomerResponseDto customerResponseDto =
                customerService.addCustomer(customerRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerResponseDto);
    }
}