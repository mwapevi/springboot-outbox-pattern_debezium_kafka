package com.customerdetails.dto;

/**
 * Lombok annotation that automatically generates getter and getter methods
 * for all fields in a class. This is done to reduce boilerplate code.
 */
import lombok.Getter;
import lombok.Setter;

@Getter  //Lombok annotation to generate getter method
@Setter  //Lombok annotation to generate setter method
public class CustomerRequestDto {

    private String firstName;   //Customer firstname
    private String lastName;   //Customer lastname
    private String emailAddress; //Customer email address
    private String physicalAddress;  //Customer physical address
}
