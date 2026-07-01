# Student Management System

A secure REST API built with Spring Boot that manages Students and Departments using JWT Authentication and Role-Based Authorization.

---

## Features

- User Registration
- User Login
- JWT Authentication
- Role-Based Authorization (ADMIN / USER)
- BCrypt Password Encryption
- Student CRUD Operations
- Department CRUD Operations
- Global Exception Handling
- DTO Mapping
- Spring Security
- Spring Data JPA
- MySQL Database

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Hibernate
- MySQL
- Gradle

---

## Project Structure

src
├── config
├── controller
├── dto
├── entity
├── exception
├── handler
├── mapper
├── repository
├── security
├── service
└── resources

---

## Authentication Flow

1. Register a user.
2. Login using username and password.
3. Receive a JWT Token.
4. Send the JWT in the Authorization header.

```
Authorization: Bearer <JWT_TOKEN>
```

5. JWT Filter validates the token.
6. User is authenticated.
7. Spring Security authorizes access based on user roles.

---

## Roles

| Role | Permissions |
|------|-------------|
| ADMIN | Full CRUD Operations |
| USER | Read-only Access |

---

## API Endpoints

### Authentication

POST /auth/register

POST /auth/login

---

### Students

GET /students

POST /students

PUT /students/{id}

DELETE /students/{id}

---

### Departments

GET /departments

POST /departments

PUT /departments/{id}

DELETE /departments/{id}

---

## Future Improvements

- Refresh Tokens
- Docker Support
- Swagger/OpenAPI
- Unit Testing
- Integration Testing
- Redis Caching
- File Upload Support
- Email Verification
- Pagination & Sorting

---

## Author

Bharath Kumar M
