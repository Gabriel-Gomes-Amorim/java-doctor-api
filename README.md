# JavaDoctor API

A modern REST API for managing doctors and their medical information, built with Spring Boot and PostgreSQL.

## 📋 Table of Contents

- [JavaDoctor API](#javadoctor-api)
  - [📋 Table of Contents](#-table-of-contents)
  - [✨ Features](#-features)
  - [🛠 Technologies](#-technologies)
  - [📦 Prerequisites](#-prerequisites)
  - [🚀 Installation](#-installation)
    - [1. Clone the Repository](#1-clone-the-repository)
    - [2. Start PostgreSQL with Docker](#2-start-postgresql-with-docker)
    - [3. Build the Project](#3-build-the-project)
  - [⚙️ Configuration](#️-configuration)
    - [Application Properties](#application-properties)
    - [Database Migrations](#database-migrations)
  - [▶️ Running the Application](#️-running-the-application)
  - [📁 Project Structure](#-project-structure)

## ✨ Features

- ✅ Complete CRUD operations for doctors
- ✅ Embedded address information for doctors
- ✅ Medical specialty classification (Orthopedics, Cardiology, Gynecology, Dermatology)
- ✅ Automatic timestamp management (created_at, updated_at)
- ✅ RESTful API with API versioning (/api/v1)
- ✅ Input validation with Jakarta Validation
- ✅ Database migrations with Flyway
- ✅ Object-to-DTO mapping with ModelMapper
- ✅ Professional error handling
- ✅ PostgreSQL database integration

## 🛠 Technologies

- **Java 21** - Programming language
- **Spring Boot 3.5.14** - Web framework
- **Spring Data JPA** - ORM and data access
- **PostgreSQL 16** - Database
- **Flyway** - Database migrations
- **ModelMapper** - Object mapping
- **Lombok** - Code generation
- **Jakarta Validation** - Bean validation
- **Apache Tomcat** - Web server
- **Maven** - Build tool

## 📦 Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- Docker & Docker Compose (for PostgreSQL)
- Git

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/Gabriel-Gomes-Amorim/java-doctor-api.git
cd java-doctor-api
```

### 2. Start PostgreSQL with Docker

```bash
docker compose up -d
```

This will start a PostgreSQL container with the following credentials:

- **Host:** localhost
- **Port:** 5433
- **Database:** javaDoctor
- **Username:** javaDoctor
- **Password:** javaDoctor123

### 3. Build the Project

```bash
mvn clean install
```

## ⚙️ Configuration

### Application Properties

Configuration file: `src/main/resources/application.properties`

```properties
spring.application.name=java-doctor-api
spring.datasource.url=jdbc:postgresql://localhost:5433/javaDoctor
spring.datasource.username=javaDoctor
spring.datasource.password=javaDoctor123
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

### Database Migrations

Flyway automatically manages database schema migrations from `src/main/resources/db/migration/`

## ▶️ Running the Application

```bash
mvn spring-boot:run
```

Or using Java:

```bash
java -jar target/api-0.0.1-SNAPSHOT.jar
```

The API will start on **http://localhost:8080**

## 📁 Project Structure

```
java-doctor-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── javadoctor/api/
│   │   │       ├── ApiApplication.java
│   │   │       └── modules/
│   │   │           └── doctor/
│   │   │               ├── controller/
│   │   │               │   └── DoctorController.java
│   │   │               ├── dto/
│   │   │               │   ├── DoctorDto.java
│   │   │               │   └── AddressDto.java
│   │   │               ├── entity/
│   │   │               │   ├── Doctor.java
│   │   │               │   ├── Address.java
│   │   │               │   └── Specialty.java
│   │   │               ├── repository/
│   │   │               │   └── DoctorRepository.java
│   │   │               └── service/
│   │   │                   └── DoctorService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/migration/
│   │           └── V1__create_table_doctor.sql
│   └── test/
│       └── java/
├── pom.xml
├── docker-compose.yml
└── README.md
```
