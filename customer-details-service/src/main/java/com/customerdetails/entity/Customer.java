package com.customerdetails.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;  //import Getter method from Project Lombok
import lombok.Setter;  //import Setter method from Project Lombok


@Entity //Classify this class as JPA entity to be mapped to a DB table
@Getter //Lombok annotation to generate getter method
@Setter //Lombok annotation to generate setter method
@AllArgsConstructor /*Specify the database table name an entity should be mapped to the DB, e.g Customers */
@Table(name="Customers") //Customer DB Table to map
public class Customer {

    @Id  //Id identify as Primary Key in DB table "Customer"
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*This primary key should be automatically
    generated*/
    private Long customerId;  //Unique Id of the customer
    private String firstName;  //First name of the customer
    private String lastName;   //Last name of the customer
    private String emailAddress; //Email address of the customer
    private String physicalAddress; //Physical address of the customer

}
