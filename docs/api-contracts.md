# 📘 API Contracts – Secure API Orchestration Demo

This document defines the API contracts used in the Secure API Orchestration Demo built with Spring Boot, JWT Auth, and MongoDB.

---

## 🔐 Authentication

### Login

**Endpoint:**  
`POST /auth/login`

**Request Body:**
```json
{
  "username": "test",
  "password": "test123"
}

Response:
{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}
```
Notes:
Use the returned token in the Authorization header for all secured endpoints:
Authorization: Bearer <token>

***👤 Customers***

All endpoints below require a valid Bearer token.

1.Get All Customers

***GET /api/customers***

Response:
[
  {
    "id": "64ff6e3e2fa4d0230dce1e6b",
    "firstName": "Hitaishi",
    "lastName": "N",
    "email": "test@example.com",
    "phone": "9876543210",
    "status": "ACTIVE"
  }
]

2. Get Customer by ID

***GET /api/customers/{id}***

Response:
{
  "id": "64ff6e3e2fa4d0230dce1e6b",
  "firstName": "Hitaishi",
  "lastName": "N",
  "email": "test@example.com",
  "phone": "9876543210",
  "status": "ACTIVE"
}

3. Create Customer

***POST /api/customers***

Request Body:
{
  "firstName": "Hitaishi",
  "lastName": "N",
  "email": "test@example.com",
  "phone": "9876543210",
  "status": "ACTIVE"
}
***Response:***
{
  "id": "64ff6e3e2fa4d0230dce1e6b",
  "firstName": "Hitaishi",
  "lastName": "N",
  "email": "test@example.com",
  "phone": "9876543210",
  "status": "ACTIVE"
}

4. Delete Customer

***DELETE /api/customers/{id}***

Response:
HTTP 204 No Content
