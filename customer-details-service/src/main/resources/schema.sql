-- schema.sql
-- Database schema for Customer service with Transactional Outbox Pattern

-- Create customer table
CREATE TABLE IF NOT EXISTS customer (
    customer_id BIGINT NOT NULL AUTO_INCREMENT,
    email_address VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    physical_address VARCHAR(255),
    PRIMARY KEY (customer_id)
);


-- Create outbox event table
CREATE TABLE IF NOT EXISTS customer_outbox (
    aggregate_id VARCHAR(36) NOT NULL,
    aggregate_type VARCHAR(100) NOT NULL,
    event_type VARCHAR(150) NOT NULL,
    payload TEXT NOT NULL,
    status ENUM('FAILED', 'PENDING', 'SENT') DEFAULT 'PENDING',
    created_at DATETIME(6),
    processed_at DATETIME(6),
    PRIMARY KEY (aggregate_id)
);