# Team17 API Contracts

## Project
Integrated Rural Health & Sanitation Management

## Technology
- Java 21
- Spring Boot
- Maven
- REST APIs
- MySQL
- HTML, CSS, JavaScript

## Service Ownership
- Healthcare: Residents, health centres, appointments and consultations
- Inventory: Medicines, stock and replenishment
- Health Camps: Camps, beneficiaries and follow-ups
- Sanitation: Facilities, complaints and water-quality observations
- Frontend and Integration: UI, dashboard, API integration and testing

## API Conventions
- Use REST APIs and JSON.
- Use plural resource names.
- Use appropriate HTTP methods and status codes.
- Validate input data.
- Document endpoints before integration.
- Each service owns its data.
- Never commit passwords or credentials.

## First End-to-End Feature
Register a resident through the frontend, save the record through the REST API, persist it in MySQL, and display the saved resident in the frontend.