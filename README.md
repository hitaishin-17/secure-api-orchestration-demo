# Secure API Orchestration Demo

This is a Spring Boot demo application that showcases secure API orchestration using:
- JWT-based authentication
- MongoDB for data persistence
- Role-based access control
- RESTful APIs for managing customer data

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security
- MongoDB
- JWT (JJWT)
- OpenAPI / Swagger UI

---

## 📦 Features

- User login to generate JWT token
- Protected API endpoints with Bearer token authentication
- CRUD operations for customers
- Status handling via enum
- Swagger-based API documentation

---

## 🚀 Getting Started

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

## 📡 API Endpoints

### 🔐 Authentication

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

### Author

Hitaishi N


