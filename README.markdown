# Job Management App

A Spring Boot application for managing companies and job postings with RESTful APIs, powered by PostgreSQL and containerized with Docker. This project allows users to create, read, update, and delete (CRUD) companies and jobs, with a clean layered architecture.

## Features

- **Company Management**: Create, update, delete, and list companies (name, description).
- **Job Management**: Add, update, delete, and view job postings (title, description, salary range, location) linked to companies.
- **REST APIs**: Endpoints like `/companies` and `/jobs` for easy integration.
- **PostgreSQL**: Stores data with JPA for seamless database operations.
- **Docker Support**: Runs PostgreSQL and pgAdmin via Docker Compose for quick setup.

## Tech Stack

- **Backend**: Spring Boot, Spring Data JPA
- **Database**: PostgreSQL
- **Containerization**: Docker, Docker Compose
- **Tools**: Maven, Postman (for API testing), pgAdmin

## Project Structure

```
src/main/java/com/example/Jobdone/
├── company/
│   ├── Company.java
│   ├── CompanyController.java
│   ├── CompanyRepository.java
│   ├── CompanyService.java
│   └── impl/CompanyServiceImplementation.java
├── Job/
│   ├── Job.java
│   ├── JobController.java
│   ├── JobRepository.java
│   ├── JobService.java
│   └── imlp/JobServiceImplementation.java
└── resources/
    └── application.properties
```

## Prerequisites

- **Java**: JDK 17 or later
- **Maven**: For building the project
- **Docker**: For running PostgreSQL and pgAdmin
- **PostgreSQL Client**: pgAdmin, DBeaver, or `psql` (optional for manual queries)
- **Postman**: For testing APIs

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd job-management-app
```

### 2. Set Up PostgreSQL with Docker
The project uses Docker Compose to run PostgreSQL and pgAdmin. Ensure Docker and Docker Compose are installed.

1. Create a `docker-compose.yml` file (provided below) in the project root.
2. Run:
   ```bash
   docker-compose up -d
   ```
3. Access PostgreSQL at `localhost:5432` (username: `ghanshyam`, password: `ghanshyam`).
4. Access pgAdmin at `http://localhost:5050` (default email: `pgadmin4@admin.org`, password: `admin`).

**Docker Compose Configuration**:
The app uses a Dockerized PostgreSQL and pgAdmin setup for portability. The configuration defines a `postgres` service (database) and a `pgadmin` service (web interface) on a shared network.

### 3. Configure the Application
The `application.properties` file is pre-configured for PostgreSQL:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/jobdone
spring.datasource.username=ghanshyam
spring.datasource.password=ghanshyam
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```
- **Note**: `create-drop` recreates the schema on startup. For persistent data, change to `update`.

### 4. Build and Run
```bash
mvn clean install
mvn spring-boot:run
```
The app runs on `http://localhost:8080`.

## API Endpoints

### Company APIs
- **GET /companies**: List all companies.
- **POST /companies**: Create a company (e.g., `{"name": "Tech Corp", "description": "A tech company"}`).
- **GET /companies/{id}**: Get a company by ID.
- **PUT /companies/{id}**: Update a company.
- **DELETE /companies/{id}**: Delete a company.

### Job APIs
- **GET /jobs**: List all jobs.
- **POST /jobs**: Create a job (e.g., `{"title": "Developer", "description": "Java role", "minSalary": "50000", "maxSalary": "80000", "location": "Remote", "company": {"id": 1}}`).
- **GET /jobs/{id}**: Get a job by ID.
- **PUT /jobs/{id}**: Update a job.
- **DELETE /jobs/{id}**: Delete a job.

Test APIs using Postman or cURL. Example:
```bash
curl -X POST http://localhost:8080/companies -H "Content-Type: application/json" -d '{"name": "Tech Corp", "description": "A tech company"}'
```

## View Data in PostgreSQL
1. Log into pgAdmin at `http://localhost:5050`.
2. Add a server with host `postgres_container`, username `ghanshyam`, and password `ghanshyam`.
3. Run queries:
   ```sql
   SELECT * FROM company;
   SELECT * FROM job;
   ```

## Actuator Endpoints
Monitor the app using Spring Boot Actuator:
- Health: `http://localhost:8080/actuator/health`
- Info: `http://localhost:8080/actuator/info`

## Notes
- **Database Schema**: Tables `company` and `job` are created automatically by JPA. `job.company_id` is a foreign key to `company.id`.


## Contributing
Feel free to fork the repo, submit issues, or contribute features! Open a pull request with your changes.
