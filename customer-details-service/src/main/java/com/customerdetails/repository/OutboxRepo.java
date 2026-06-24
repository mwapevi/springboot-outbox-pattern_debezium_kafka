package com.customerdetails.repository;

import com.customerdetails.outbox.entity.CustomerOutbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OutboxRepo extends JpaRepository<CustomerOutbox, UUID> {
}
