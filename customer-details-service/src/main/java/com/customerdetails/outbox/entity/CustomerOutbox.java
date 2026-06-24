package com.customerdetails.outbox.entity;

import com.customerdetails.constants.OutBoxStatus;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import java.sql.Types;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CustomerOutbox")
public class CustomerOutbox {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(Types.VARCHAR)
    private UUID aggregateId;

    @Column(name="aggregate_type",nullable = false, length =100)
    private String aggregateType;

    @Column(name="event_type", nullable = false, length=150)
    private String eventType;

    @Lob
    @Column(name="payload", nullable = false, columnDefinition = "TEXT")
    private String payload;


    @Enumerated(EnumType.STRING)
    private OutBoxStatus status;

    @Column(name="Created_At")
    private LocalDateTime createdAt;

    @Column(name="processed_at")
    private LocalDateTime processedAt;

}
