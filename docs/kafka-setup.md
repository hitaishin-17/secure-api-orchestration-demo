### Kafka Setup for Secure API Orchestration Demo

This guide outlines how to integrate Apache Kafka into the Secure API Orchestration Demo for distributed asynchronous processing.

⸻

## Why Kafka?

Kafka enables event-driven architecture by decoupling producers and consumers. It allows background jobs and external systems to react to application events (e.g., customer creation).

Use cases:
	•	Notify CRM systems
	•	Trigger analytics
	•	Send emails asynchronously
	•	Log audit events

⸻

## Prerequisites
	•	Apache Kafka and Zookeeper running on localhost
	•	Spring Boot project already set up
	•	spring-kafka dependency in pom.xml

<dependency>
  <groupId>org.springframework.kafka</groupId>
  <artifactId>spring-kafka</artifactId>
</dependency>


⸻

## Spring Boot Kafka Config (application.yml)

spring:
  kafka:
    bootstrap-servers: localhost:9092
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
    consumer:
      group-id: customer-group
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer


⸻

## Kafka Producer Example

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendCustomerCreatedEvent(String customerJson) {
        kafkaTemplate.send("customer.created", customerJson);
    }
}


⸻

## Kafka Consumer Example

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "customer.created", groupId = "customer-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
        // Process downstream actions
    }
}


⸻

## Testing
	•	Use Postman to POST a new customer
	•	Ensure the Kafka consumer prints the event

⸻

## Notes
	•	Use JSON serialization for messages (e.g., new Gson().toJson(customer))
	•	Consider using a dedicated DTO class and Jackson for structured messages
	•	Secure Kafka with SSL in production

⸻

✅ Kafka now enables distributed async flows in your orchestration layer!
