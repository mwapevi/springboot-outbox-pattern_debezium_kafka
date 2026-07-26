package com.customerdetails.outbox.entity;

import com.customerdetails.constants.OutBoxStatus;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import java.sql.Types;

@Entity
@Table(name = "customer_outbox") // Maps this entity to the customer_outbox table in MySQL
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOutbox {

    // Unique identifier for each outbox event.
    // Generated automatically as a UUID by Hibernate.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Identifier of the business entity (aggregate) that produced this event.
    // Example: the Customer ID.
    @Column(name = "aggregate_id", nullable = false)
    private Long aggregateId;

    // Type of aggregate that generated the event.
    // Example: "Customer", "Order", or "Payment".
    @Column(name = "aggregate_type", nullable = false)
    private String aggregateType;

    // Describes the business event.
    // Example: "CustomerCreated", "CustomerUpdated".
    @Column(name = "event_type", nullable = false)
    private String eventType;

    // JSON representation of the event payload.
    // Stored as TEXT because the payload size can vary.
    @Lob
    @Column(name = "payload", nullable = false)
    private String payload;

    // Current processing state of the outbox event.
    // Stored as a String in the database (e.g., PENDING, SENT, FAILED).
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OutBoxStatus status;

    // Timestamp indicating when the outbox event was created.
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Timestamp indicating when the event was successfully processed.
    // Will remain null until processing is complete.
    @Column(name = "processed_at")
    private LocalDateTime processedAt;
}