# JWT Authentication in Secure API Orchestration Demo

This document describes how JWT (JSON Web Token) authentication is implemented in the Secure API Orchestration Demo.

⸻

## 🔐 What is JWT?

JWT is a stateless, compact, and URL-safe token format used for securely transmitting information between parties. It’s signed using a secret or public/private key pair to ensure data integrity and authenticity.

⸻

## Core Concepts
	•	Token Structure: JWT = Header + Payload + Signature
	•	Bearer Token: Sent in the Authorization header
	•	Stateless Auth: No need to store sessions on the server

⸻

## Implementation Details

**1. Login Endpoint**
	•	URL: POST /auth/login
	•	Request: { "username": "test", "password": "test123" }
	•	Response: { "token": "<JWT token>" }

**2. JWT Token Generation**
	•	Uses io.jsonwebtoken.Jwts
	•	Encodes username as subject
	•	Sets issued time and expiry (e.g., 1 hour)

```java
public String generateToken(String username) {
    return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
            .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256)
            .compact();
}
```

**3. JWT Validation**
	•	Token is parsed and validated for:
	•	Signature
	•	Expiry
	•	Matching username from UserDetails

**4. JWT Filter**
	•	Intercepts all incoming requests
	•	Extracts token from header
	•	Validates and sets security context

```java
String token = extractToken(request);
String username = jwtUtil.extractUsername(token);

if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    if (jwtUtil.validateToken(token, userDetails)) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }
}
```


⸻

## How to Use in Postman
	1.	Call POST /auth/login with valid credentials
	2.	Copy the token from the response
	3.	Add header to any protected API call:

Authorization: Bearer <token>

⸻

## Test Users
	•	Username: test
	•	Password: test123

⸻

## Security Tips
	•	Keep secret key secure (e.g., env vars)
	•	Use HTTPS to protect token in transit
	•	Set appropriate token expiration
	•	Consider refresh tokens for long sessions

⸻

## Libraries Used
	•	Spring Security
	•	jjwt (Java JWT)

⸻

✅ This setup ensures secure, scalable, and stateless authentication for APIs.
