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

### ✅ Day 3 | 05-08-2026

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

### ✅ Day 4 | 06-08-2026

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

### ✅ Day 5 | 10-08-2026

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
