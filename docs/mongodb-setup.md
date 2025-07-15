# MongoDB Setup for Secure API Orchestration Demo

This document provides steps to set up MongoDB for the Secure API Orchestration Demo project.

⸻

## Prerequisites
	•	MongoDB installed locally or via Docker
	•	Ensure port 27017 is available
	•	MongoDB Compass (optional for GUI-based inspection)

⸻

## Option 1: Install MongoDB Locally

macOS (Homebrew)

brew tap mongodb/brew
brew install mongodb-community@7.0
brew services start mongodb/brew/mongodb-community

Windows

Download from: https://www.mongodb.com/try/download/community

Follow the installer, and ensure MongoDB is added to your PATH.

⸻

## Option 2: Using Docker

docker-compose.yml
```
version: '3.8'
services:
  mongodb:
    image: mongo:7.0
    container_name: mongo-container
    ports:
      - "27017:27017"
    volumes:
      - ./mongo-data:/data/db
```
Run it

docker-compose up -d


⸻

## Test MongoDB Connection

Using CLI

mongo

Using Compass

Connect to:

mongodb://localhost:27017


⸻

## Database Details for This Project
	•	Database: secureapi
	•	Collections:
	  •	customers
	  •	users

These are auto-created by Spring Data MongoDB when inserting documents.

⸻

## Spring Boot Application Properties

Ensure your application.properties or application.yml contains:

spring.data.mongodb.uri=mongodb://localhost:27017/secureapi
