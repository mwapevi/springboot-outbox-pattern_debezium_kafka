package com.customerdetails.mapper;

import com.customerdetails.dto.CustomerRequestDto;
import com.customerdetails.dto.CustomerResponseDto;
import com.customerdetails.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CustomerMapper {

    Customer toEntity(CustomerRequestDto customerRequestDto);

    CustomerResponseDto toDto(Customer customer);
}
