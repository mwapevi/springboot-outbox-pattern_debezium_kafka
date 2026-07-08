package com.customerdetails.service;

import com.customerdetails.dto.CustomerRequestDto;
import com.customerdetails.dto.CustomerResponseDto;
import com.customerdetails.entity.Customer;
import com.customerdetails.outbox.entity.CustomerOutbox;
import com.customerdetails.mapper.CustomerMapper;
import com.customerdetails.repository.CustomerRepo;
import com.customerdetails.repository.OutboxRepo;
import com.customerdetails.constants.OutBoxStatus;
import com.customerdetails.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper mapper;
    private final OutboxRepo outboxRepo;

    @Transactional
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

        Customer customer = mapper.toEntity(customerRequestDto);

        Customer savedCustomer = customerRepo.save(customer);

        CustomerOutbox outbox = new CustomerOutbox();
        outbox.setPayload(JsonUtil.toJson(savedCustomer));
        outbox.setAggregateType("Customer");
        outbox.setEventType("Customer Registration");
        outbox.setStatus(OutBoxStatus.PENDING);
        outbox.setCreatedAt(LocalDateTime.now());
        outbox.setProcessedAt(LocalDateTime.now());

        outboxRepo.save(outbox);

        return mapper.toDto(savedCustomer);
    }
}