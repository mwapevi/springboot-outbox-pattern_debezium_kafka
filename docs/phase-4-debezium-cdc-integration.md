← [Back to README](/README.md)

# Phase 3: Integrating Debezium Change Data Capture (CDC)

## Overview

The primary objective of this phase was to integrate Debezium Change Data Capture (CDC) into the event-driven architecture developed in Phase 1 and Phase 2, enabling reliable, near real-time event streaming without requiring changes to the application logic.

In the previous phases, business events were persisted to an Outbox table as part of the same database transaction that updated the application's business data. This ensured transactional consistency by guaranteeing that both the business operation and its corresponding event were committed atomically.

In this phase, Debezium was introduced to bridge the gap between the database and Apache Kafka. Rather than relying on the application to publish events directly to Kafka or periodically polling the Outbox table, Debezium continuously monitors the MySQL Binary Log (binlog) for database changes. Whenever a new record is inserted into the Outbox table, Debezium captures the change almost immediately and publishes it as a Kafka event.

This architecture provides several key advantages:

- Near real-time event propagation with minimal latency.
- Reduced database overhead by eliminating continuous polling of the Outbox table.
- Reliable event delivery, as events are captured directly from the database transaction log.
- Loose coupling between the application and the messaging infrastructure, allowing the application to focus solely on business logic while Debezium handles event publication.
- Scalability, enabling multiple downstream consumers to independently process the same event stream.

By integrating Debezium into the existing Outbox Pattern architecture, the solution achieves a robust and production-ready event-driven design that guarantees transactional consistency while enabling efficient, scalable, and asynchronous communication between microservices.

## Objectives

During the integration of Debezium Change Data Capture (CDC) into the existing event-driven architecture, the following objectives were defined for this phase:

- Configure Debezium to monitor the MySQL Binary Log (binlog) for database changes.
- Capture INSERT, UPDATE, and DELETE operations from the database in near real time.
- Monitor the Outbox table for newly created business events.
- Configure Kafka Connect with a Debezium MySQL source connector.
- Publish captured Outbox events automatically to Apache Kafka topics.
- Eliminate database polling by leveraging log-based change data capture.
- Ensure reliable and consistent event propagation from the database to Kafka.
- Decouple the application from the event publishing process by offloading message streaming to Debezium.

### Debezium Configuration



