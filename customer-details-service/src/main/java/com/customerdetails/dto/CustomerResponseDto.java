package com.customerdetails.dto;
/**
 * Lombok annotation that automatically generates getter and getter methods
 * for all fields in a class. This is done to reduce boilerplate code.
 */
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerResponseDto {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String physicalAddress;
}
