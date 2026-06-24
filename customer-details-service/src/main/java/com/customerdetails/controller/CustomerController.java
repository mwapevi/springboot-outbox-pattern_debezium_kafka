package com.customerdetails.controller;

import com.customerdetails.dto.CustomerRequestDto;
import com.customerdetails.dto.CustomerResponseDto;
import com.customerdetails.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@Controller
@RequestMapping("/api/v1")

public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerResponseDto>
    addNewCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        CustomerResponseDto customerResponseDto=
                customerService.addCustomer(customerRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDto);
    }

}
