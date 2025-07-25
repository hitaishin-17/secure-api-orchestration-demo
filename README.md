# Secure API Orchestration Demo

This is a Spring Boot demo application that showcases secure customer API orchestration using:
- JWT-based authentication
- MongoDB for data persistence
- Role-based access control
- RESTful APIs for managing customer data

---
## Why I Built This

Modern backend platforms often struggle to balance security, event-driven scale, and developer clarity.

I built this project to:
- Create modular, secure APIs with JWT-based authentication
- Demonstrate async event-driven workflows using Kafka
- Provide dev teams with real-world patterns for API + orchestration logic

⸻
## Potential Impact & Use Case Metrics

This project simulates a real-world secure API orchestration system with measurable backend and platform benefits:

| Metric                             | Impact                                                                 |
|-----------------------------------|------------------------------------------------------------------------|
|  **Auth Success Rate**          | Secure JWT-based login flow eliminates unauthorized access to protected endpoints. |
|  **API Response Time**           | Average response time under 100ms in local testing — simulates low-latency backend ops. |
|  **Workflow Automation Coverage**| Kafka-based events replace 100+ manual follow-ups (e.g., CRM updates, audit logging). |
|  **Developer Onboarding Time**  | Swagger UI + Postman collection enables <15 min onboarding for new devs. |
|  **System Modularity**          | Designed for plug-and-play orchestration patterns in microservice environments. |


## Example User Story

As a Platform Engineer,
I want secure, token-authenticated APIs with async workflows,
So I can manage customer data and trigger downstream events with minimal manual handling.


## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security
- MongoDB
- JWT (JJWT)
- OpenAPI / Swagger UI

---

## Features

- User login to generate JWT token
- Protected API endpoints with Bearer token authentication
- CRUD operations for customers
- Status handling via enum
- Swagger-based API documentation

---
## Architecture Diagram
![Architecture Diagram](docs/architecture_diagram.jpeg)

## Getting Started

### 1. Prerequisites

- Java 17
- Maven
- MongoDB (running on `localhost:27017`)
- (Optional) Docker & Docker Compose

---

### 2. Clone the Repository

```bash
git clone https://github.com/hitaishin-17/secure-api-orchestration-demo.git
cd secure-api-orchestration-demo

### Setup & Run

Option A: Run from IntelliJ
	•	Open project
	•	Run SecureApiOrchestrationApp.java

## API Endpoints

### Authentication

| Method | Endpoint         | Description                       |
|--------|------------------|-----------------------------------|
| POST   | `/auth/login`    | Login with JSON body              |
|        |                  | `{ "username": "test", "password": "test123" }` |

> Returns a JWT token. Use it in the `Authorization` header as `Bearer <token>`.

---

### 👤 Customers

All endpoints below require a valid Bearer token in the `Authorization` header.

| Method | Endpoint               | Description               |
|--------|------------------------|---------------------------|
| GET    | `/api/customers`       | Get all customers         |
| GET    | `/api/customers/{id}`  | Get customer by ID        |
| POST   | `/api/customers`       | Create new customer       |
| DELETE | `/api/customers/{id}`  | Delete customer by ID     |

> Sample `POST` body for creating a customer:

```json
{
  "firstName": "Hitaishi",
  "lastName": "N",
  "email": "test@example.com",
  "phone": "9876543210",
  "status": "ACTIVE"
}
```

### Kafka Integration

Kafka is used to publish customer.created events asynchronously after a customer is saved.

Topic: customer.created

Producer: Publishes event from customer service

Consumer (optional): Reacts to event (e.g., sends email, logs audit, etc.)

Sample Code:

```
@Autowired
private KafkaTemplate<String, String> kafkaTemplate;

public void publishCustomerCreatedEvent(Customer customer) {
    String json = new Gson().toJson(customer);
    kafkaTemplate.send("customer.created", json);
}
```
### Sample Login Credentials
{
  "username": "test",
  "password": "test123"
}

### Swagger UI
http://localhost:8080/swagger-ui/index.html

### Docker (Optional)

If Docker is installed:
docker-compose up

Ensure docker and docker-compose are installed and MongoDB container runs successfully.

### Postman Collection

A ready-to-import Postman collection is available in the repo:
secure-api-orchestration-demo.postman_collection.json

⸻

### Contributing

Feel free to fork, suggest improvements, or raise issues.

⸻
### About me
Hi, I’m Hitaishi N — a backend engineer turned product-minded builder focused on:
- Secure API and platform architecture
- Event-driven backend systems using Kafka
- Workflow and automation tooling
- Building with a “system thinking” mindset across tech and ops

📌 I’m currently exploring roles where I can blend technical depth with product strategy — especially in internal tools, platform teams, or automation workflows.

[Connect on LinkedIn](www.linkedin.com/in/hitaishi-n-grovista)


