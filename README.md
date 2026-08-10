# 🚀 Backend Refresher Training

## Branch

**Refresher-Training**

---

## 📅 Progress Log

### ✅ Day 1 | 31-07-2026

#### 📚 Topics Covered

* DBMS Fundamentals
* Database & DBMS
* File System vs DBMS
* Types of DBMS
* RDBMS & Its Features
* SQL vs NoSQL
* Introduction to MySQL
* Creating Databases & Tables
* DDL Commands (`CREATE`, `ALTER`, `DROP`, `TRUNCATE`, `RENAME`)
* DML Commands (`INSERT`, `UPDATE`, `DELETE`)
* TCL Commands (`COMMIT`, `ROLLBACK`)
* DCL Commands (`GRANT`, `REVOKE`)

#### 💻 Practical Work

* Created `health_clinic_db`
* Created the following tables:
  * Patients
  * Doctors
  * Specializations
  * Appointments
* Inserted sample records into all tables
* Performed `ALTER TABLE` operations
* Executed `UPDATE` and `DELETE` queries using `WHERE`
* Practiced transaction handling using `COMMIT` and `ROLLBACK`
* Created a new MySQL user and assigned required privileges

#### 📂 Files

* `Day-1/Day1.sql`

#### 📌 Status

**Completed ✅**

---

### ✅ Day 2 | 03-08-2026

#### 📚 Topics Covered

* Database Normalization
  * 1NF (First Normal Form)
  * 2NF (Second Normal Form)
  * 3NF (Third Normal Form)
  * BCNF (Boyce-Codd Normal Form)
* Denormalization
* Entity Relationship (ER) Modeling
* Cardinality & Participation Constraints
* Database Indexing
* Clustered vs Non-Clustered Index
* Composite Index
* Covering Index
* Query Optimization using `EXPLAIN`

#### 💻 Practical Work

* Normalized an `orders` table into 3NF
* Created the following tables:
  * Customers
  * Products
  * Orders
  * Order_Items
* Extended the Health Clinic database by adding:
  * Rooms
  * Doctor_Room (Junction Table)
* Created Single Column, Composite, and Covering Indexes
* Analyzed query execution plans using `EXPLAIN`
* Practiced SQL queries for indexing and normalization assignments

#### 📂 Files

* `Day-2/Day2.sql`
* `Day-2/Health_Clinic_ER_Diagram.png`
#### 📌 Status

**Completed ✅**

---

### ✅ Day 3 | 04-08-2026

#### 📚 Topics Covered

* SQL Joins
  * INNER JOIN
  * LEFT JOIN
  * RIGHT JOIN
  * FULL OUTER JOIN (MySQL Simulation)
  * SELF JOIN
  * CROSS JOIN
  * Multiple Table JOIN
* Stored Procedures
  * Introduction to Stored Procedures
  * Creating Procedures
  * Calling Procedures
  * IN Parameters
  * OUT Parameters
  * INOUT Parameters
  * Error Handling using Handlers
* Triggers
  * BEFORE INSERT
  * AFTER INSERT
  * BEFORE UPDATE
  * AFTER UPDATE
  * BEFORE DELETE
  * AFTER DELETE

#### 💻 Practical Work

* Executed all types of SQL JOIN operations on the Health Clinic database
* Retrieved patient, doctor, specialization, appointment, and billing details using multiple table joins
* Identified patients and doctors without appointments using LEFT JOIN
* Simulated FULL OUTER JOIN using UNION
* Implemented SELF JOIN for hierarchical relationships
* Generated Cartesian products using CROSS JOIN
* Created and executed stored procedures with IN, OUT, and INOUT parameters
* Implemented error handling using `DECLARE HANDLER`, `START TRANSACTION`, `COMMIT`, and `ROLLBACK`
* Created triggers for validation, audit logging, automatic visit history creation, billing updates, and deletion restrictions
* Solved SQL practice queries related to Joins, Stored Procedures, and Triggers

#### 📂 Files

* `Day-3/Day3.sql`

#### 📌 Status

**Completed ✅**

---

### ✅ Day 4 | 05-08-2026

#### 📚 Topics Covered
* JDBC (Java Database Connectivity) Fundamentals
* JDBC Architecture & Driver Types
* Connection URL, DriverManager, and `Connection` Object
* `Statement` vs `PreparedStatement`
* Preventing SQL Injection using `PreparedStatement`
* `ResultSet` Navigation and Data Retrieval
* Try-with-Resources for Automatic Resource Management
* CRUD Operations via JDBC (`INSERT`, `SELECT`, `UPDATE`, `DELETE`)
* DTO (Data Transfer Object) Design Pattern
* DAO (Data Access Object) Design Pattern
* Layered Application Architecture (UI → Service → DAO → DTO)
* Transaction Management in JDBC (`setAutoCommit`, `commit`, `rollback`)
* ACID Properties — Atomicity in Practice
* Connection Pooling using HikariCP
* Maven Project Setup & Dependency Management

#### 💻 Practical Work
* Built a complete **Health Clinic Management Console Application** in Java using JDBC + MySQL
* Designed and implemented 6 DTO classes: `Patient`, `Doctor`, `Specialization`, `Appointment`, `Billing`, `VisitHistory`
* Implemented `HikariConnectionPool` for pooled database connections, replacing a single-connection `DriverManager` setup
* Built 6 DAO interface + implementation pairs with full CRUD operations using `PreparedStatement` and try-with-resources
* Implemented `AppointmentService` as the transactional safety layer — coordinating appointment status updates, billing creation, and visit history logging as a single atomic transaction using shared connections, `commit()`, and `rollback()`
* Built a full `ConsoleMenu` UI covering registration, search, update, and deletion for patients, doctors, specializations, appointments, billing, and visit history
* Wired the entire layered architecture together via `Main.java`
* Verified transaction rollback behavior by intentionally failing mid-transaction and confirming no partial data was saved
* Set up the project as a Maven build with `mysql-connector-j` and `HikariCP` dependencies

#### 📂 Files
* `Day-4/HealthClinicApp/` (full Maven project)
  * `pom.xml`
  * `database/health_clinic_schema.sql`
  * `src/main/java/com/clinic/` — `dto/`, `config/`, `dao/`, `service/`, `ui/`, `Main.java`

#### 📌 Status
**Completed ✅**

---

### ✅ Day 5 | 06-08-2026

#### 📚 Topics Covered

* Introduction to Spring & Spring Boot
* Inversion of Control (IoC) and the IoC Container
* Dependency Injection (constructor, setter, field)
* Spring Stereotype Annotations (`@Component`, `@Controller`, `@RestController`)
* `@SpringBootApplication` — Auto Configuration, Component Scan, Configuration
* Spring MVC Architecture
* DispatcherServlet as the Front Controller
* Request Mapping (`@RequestMapping`, `@GetMapping`, `@PostMapping`, `@PutMapping`)
* Handling Request Data — `@RequestParam`, `@PathVariable`, `@RequestBody`
* View Resolution using Thymeleaf
* Embedded Tomcat in Spring Boot (no external server setup required)
* SLF4J Logging in a Spring Boot Application

#### 💻 Practical Work

* Built **springapp** — a Spring Boot project demonstrating:
  * A `HelloRestController` exposing five REST endpoints covering plain response, query parameter, path variable, request body, and PUT request handling
  * A `HelloWebController` returning Thymeleaf views for a basic MVC flow
  * `EmployeeBean` and `DepartmentBean` components wired together via constructor-based dependency injection, with wiring confirmed through SLF4J log output on startup
* Built **greetings-webapp** — a focused Spring MVC application:
  * `GreetingFormController` serving an input form (`index.html`) and a result page (`greeting.html`)
  * Demonstrated the DispatcherServlet → Controller → Model → View flow end to end
  * Styled with a custom stylesheet served from `static/css`
* Verified both applications run on the Spring Boot **embedded Tomcat server** with no manual Tomcat installation or configuration
* Confirmed successful startup and request handling for both projects via Maven (`mvn spring-boot:run`)

#### 📂 Files

* `Day-5/springapp/` (full Maven project)
  * `pom.xml`
  * `src/main/java/com/bridgelabz/springapp/` — `controller/`, `model/`, `component/`, `SpringAppApplication.java`
  * `src/main/resources/templates/`, `application.properties`
* `Day-5/greetings-webapp/` (full Maven project)
  * `pom.xml`
  * `src/main/java/com/bridgelabz/greetings/` — `controller/`, `GreetingsWebAppApplication.java`
  * `src/main/resources/templates/`, `static/css/`, `application.properties`

#### 📌 Status

**Completed ✅**

---

### ✅ Day 6 | 07-08-2026

#### 📚 Topics Covered

* Spring Data JPA Fundamentals
* JPA Entities — `@Entity`, `@Id`, `@GeneratedValue`
* `JpaRepository` and Built-in CRUD Methods (`save`, `findAll`, `findById`, `deleteById`)
* H2 In-Memory Database Setup and Configuration
* `spring.jpa.hibernate.ddl-auto` and Schema Auto-Generation
* H2 Console for Inspecting Runtime Data
* Full CRUD Flow through Spring MVC (Create, Read, Update, Delete via Controller + Views)
* Thymeleaf Iteration and Conditionals (`th:each`, `th:if`)
* Redirect-after-POST Pattern (Post/Redirect/Get)
* Handling "Not Found" Cases with `Optional` and `orElseThrow`

#### 💻 Practical Work

* Built **greetings-crud-app** — a Spring Boot project extending the Day 5 MVC flow with persistence:
  * `GreetingNote` JPA entity representing a saved greeting (sender name + note)
  * `GreetingNoteRepository` extending `JpaRepository` for zero-boilerplate CRUD access
  * `GreetingBoardController` wiring up all five CRUD routes:
    * `GET /` — list all saved greetings with the create form
    * `POST /notes` — create a new greeting
    * `GET /notes/{id}` — view a single greeting
    * `GET /notes/{id}/edit` and `POST /notes/{id}` — edit form and save changes
    * `POST /notes/{id}/delete` — delete a greeting
  * Three Thymeleaf views (`index.html`, `view.html`, `edit.html`) driving the full CRUD UI
  * Configured an H2 in-memory database with `spring.jpa.hibernate.ddl-auto=update` for automatic schema creation
* Verified the app on the Spring Boot **embedded Tomcat server**, no manual server setup required
* Inspected persisted rows at runtime using the built-in H2 console at `/h2-console`
* Confirmed create, view, edit, and delete operations all work correctly end to end via `mvn spring-boot:run`

#### 📂 Files

* `Day-6/greetings-crud-app/` (full Maven project)
  * `pom.xml`
  * `src/main/java/com/bridgelabz/greetingsapp/` — `GreetingNote.java`, `GreetingNoteRepository.java`, `GreetingBoardController.java`, `GreetingsCrudAppApplication.java`
  * `src/main/resources/templates/`, `static/css/`, `application.properties`

#### 📌 Status

**Completed ✅**

---

### ✅ Day 7 | 10-08-2026

#### 📚 Topics Covered

* Spring Boot REST API Design
* RESTful CRUD Conventions (`@RestController`, `@RequestMapping`, `@PostMapping`, `@GetMapping`)
* Spring Data JPA & Hibernate with a Layered Architecture (Controller → Service → Repository → Database)
* Entity Modeling — `@Table` Indexes and Unique Constraints
* DTO Pattern for Request/Response Separation
* Bean Validation (`@NotBlank`, `@Email`) on Incoming Requests
* Custom Exceptions and Centralized Error Handling with `@RestControllerAdvice`
* Structured Error Responses (timestamp, status, error, message, path)
* H2 In-Memory Database & H2 Console
* Spring Boot Actuator for Health, Info, and Metrics Endpoints
* HikariCP Connection Pool (Spring Boot default)

#### 💻 Practical Work

* Built **contact-directory-api** — a Spring Boot REST API for managing contacts:
  * `ContactEntity` JPA entity with a unique constraint on phone number and email, and an index on full name
  * `ContactCreateRequest` and `ContactResponse` DTOs keeping persistence and API contracts separate
  * `ContactRepository` extending `JpaRepository`, with `existsByPhoneNumber` / `existsByEmailAddress` checks
  * `ContactService` / `ContactServiceImpl` enforcing duplicate-phone and duplicate-email business rules before saving
  * `ContactController` exposing:
    * `POST /api/v1/contacts` — create a contact
    * `GET /api/v1/contacts` — list all contacts
    * `GET /api/v1/contacts/{id}` — fetch a contact by id
  * `ContactNotFoundException`, `DuplicateContactException`, `ApiError`, and `GlobalRestExceptionHandler` for consistent, centralized error responses
  * Bean Validation on the create request, with field-level error messages returned on invalid input
* Configured an H2 in-memory database (`create-drop` schema mode) with the H2 console enabled at `/h2-console`
* Enabled Spring Boot Actuator (`health`, `info`, `metrics`) for basic runtime observability
* Verified create, list, and get-by-id flows, duplicate rejection, and validation error responses end to end

#### 📂 Files

* `Day-7/contact-directory-api/` (full Maven project)
  * `pom.xml`
  * `src/main/java/com/training/contactdirectory/` — `controller/`, `dto/`, `entity/`, `exception/`, `repository/`, `service/`, `ContactDirectoryApiApplication.java`
  * `src/main/resources/application.properties`
  * `src/test/java/com/training/contactdirectory/ContactDirectoryApiApplicationTests.java`

#### 📌 Status

**Completed ✅**
