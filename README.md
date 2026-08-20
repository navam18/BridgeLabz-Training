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

---

### ✅ Day 8 | 11-08-2026

#### 📚 Topics Covered

* Completing the RESTful CRUD Surface (`@PutMapping`, `@DeleteMapping`)
* Separate DTO Contracts for Create vs Update Operations
* Uniqueness Validation on Update — Excluding the Record's Own Id (`existsBy...AndIdNot`)
* Not-Found Handling on Update and Delete (`orElseThrow`, `existsById`)
* Idempotent Delete Semantics (`204 No Content`)
* Extending Centralized Exception Handling to New Endpoints

#### 💻 Practical Work

* Extended **contact-directory-api** from Day 7 to a complete CRUD API by adding Update and Delete:
  * `ContactUpdateRequest` DTO, kept separate from `ContactCreateRequest` for a clean request contract
  * `ContactRepository` extended with `existsByPhoneNumberAndIdNot` / `existsByEmailAddressAndIdNot`, so updating a contact doesn't falsely collide with its own existing phone/email
  * `ContactService` / `ContactServiceImpl` extended with:
    * `updateContact(id, request)` — loads the existing contact, re-validates phone/email uniqueness against all other contacts, applies changes, and saves
    * `deleteContact(id)` — verifies existence before deleting, raising `ContactNotFoundException` otherwise
  * `ContactController` extended with:
    * `PUT /api/v1/contacts/{id}` — update an existing contact
    * `DELETE /api/v1/contacts/{id}` — delete a contact, returning `204 No Content`
  * Reused the existing `ContactNotFoundException`, `DuplicateContactException`, `ApiError`, and `GlobalRestExceptionHandler` so update/delete errors follow the same structured error response as create/read
  * Bean Validation applied to the update request as well, matching the create request's field-level error behavior
* Verified update and delete flows end to end: updating with a duplicate phone/email is rejected, updating/deleting a missing id returns a `404`, and successful update/delete behave as expected
* Contact Directory API now supports the full CRUD set: Create, Read (all + by id), Update, and Delete

#### 📂 Files

* `Day-8/contact-directory-api/` (full Maven project, extends Day 7)
  * `pom.xml`
  * `src/main/java/com/training/contactdirectory/` — `controller/`, `dto/` (adds `ContactUpdateRequest.java`), `entity/`, `exception/`, `repository/`, `service/`, `ContactDirectoryApiApplication.java`
  * `src/main/resources/application.properties`
  * `src/test/java/com/training/contactdirectory/ContactDirectoryApiApplicationTests.java`

#### 📌 Status

**Completed ✅**

---

### ✅ Day 9 | 12-08-2026

#### 📚 Topics Covered

* Building a Spring Boot CRUD API against a MySQL Database (instead of H2)
* MySQL Datasource Configuration (`spring.datasource.url/username/password`)
* JPA Entity Mapping without DTOs — Direct Entity Exposure over REST
* Constructor-based Dependency Injection in Controller and Service layers
* `spring.jpa.hibernate.ddl-auto=update` for Incremental Schema Evolution
* Null-safe Lookups with `Optional.orElse(null)`
* Basic Layered Architecture (Controller → Service → Repository → Entity)

#### 💻 Practical Work

* Built **student-management** — a Spring Boot REST API for managing students, backed by MySQL:
  * `Student` JPA entity (`id`, `name`, `email`, `course`, `age`) with standard getters/setters
  * `StudentRepository` extending `JpaRepository` for out-of-the-box persistence
  * `StudentService` implementing the full CRUD set: `createStudent`, `getAllStudent`, `getStudentById`, `updateStudent`, `deleteStudent`
  * `StudentController` exposing:
    * `POST /students` — create a student
    * `GET /students` — list all students
    * `GET /students/{id}` — fetch a student by id
    * `PUT /students/{id}` — update an existing student
    * `DELETE /students/{id}` — delete a student
  * Configured `application.properties` to connect to a local MySQL `student_db` database with `ddl-auto=update`
* Verified create, list, get-by-id, update, and delete flows end to end against MySQL

#### ⚠️ Notes

* This project currently exposes the `Student` entity directly over REST (no DTOs) and has no bean validation or centralized exception handling yet — both are natural next steps, following the pattern established in the Day 7/8 `contact-directory-api`
* `application.properties` has a MySQL password committed in plain text; recommend moving it to an environment variable or a git-ignored local properties file before pushing

#### 📂 Files

* `Day-9/studentManagement/` (full Maven project)
  * `pom.xml`
  * `src/main/java/com/example/student_management/` — `controller/`, `entity/`, `repository/`, `service/`, `StudentManagementApplication.java`
  * `src/main/resources/application.properties`
  * `src/test/java/com/example/student_management/StudentManagementApplicationTests.java`

#### 📌 Status

**Completed ✅**

---

### ✅ Day 10 | 13-08-2026

#### 📚 Topics Covered

* Dependency Injection
* Spring Boot key features
* H2 Database integration and configuration
* Circular Dependency

#### 💻 Practical Work

* Initialized **employee-payroll-app** as a Spring Boot project.
* Configured Spring Boot with:
  * Spring Data JPA
  * Spring Web MVC
  * H2 Database
  * H2 Console
  * Lombok
* Configured the application to run on port `8080`.
* The project currently contains the Spring Boot application class and test class; no employee payroll domain implementation is present in the Day-10 files.

#### 📂 Files

* `Day-10/employee_payroll_app/` (Spring Boot Maven project)
  * `pom.xml`
  * `src/main/java/org/example/employee_payroll_app/EmployeePayrollAppApplication.java`
  * `src/main/resources/application.properties`
  * `src/test/java/org/example/employee_payroll_app/EmployeePayrollAppApplicationTests.java`

#### 📌 Status

**Completed ✅**

---

### ✅ Day 11 | 14-08-2026

#### 📚 Topics Covered

* Continued work with the **employee-payroll-app** Spring Boot project.
* Spring Data JPA and H2 project configuration
* Spring Boot application setup

#### 💻 Practical Work

* Continued the **employee-payroll-app** project from Day 10.
* Maintained the Spring Boot Maven configuration with:
  * Spring Data JPA
  * Spring Web MVC
  * H2 Database
  * H2 Console
  * Lombok
* Kept the application configured to run on port `8080`.
* The Day-11 files contain the project setup and application/test classes; the employee payroll implementation is introduced in the Day-12 version.

#### 📂 Files

* `Day-11/employee_payroll_app/` (Spring Boot Maven project)
  * `pom.xml`
  * `src/main/java/org/example/employee_payroll_app/EmployeePayrollAppApplication.java`
  * `src/main/resources/application.properties`
  * `src/test/java/org/example/employee_payroll_app/EmployeePayrollAppApplicationTests.java`

#### 📌 Status

**Completed ✅**

---

### ✅ Day 12 | 17-08-2026

#### 📚 Topics Covered

* Building a complete Spring Boot Employee Payroll REST API
* Layered Architecture:
  * Controller
  * Service
  * Repository
  * Entity
  * DTO
* Spring Data JPA with MySQL
* DTO-based Request and Response handling
* Bean Validation using `@Valid`, `@NotBlank`, and `@NotNull`
* Custom Exception Handling
* Centralized Exception Handling using `@RestControllerAdvice`
* HTTP status handling using `ResponseEntity`
* CRUD REST API operations
* Transaction Management using `@Transactional`
* Lombok and Builder Pattern
* Salary calculation using `BigDecimal`
* MySQL schema management using `spring.jpa.hibernate.ddl-auto=update`

#### 💻 Practical Work

* Built **employee-payroll-app** as a Spring Boot REST API connected to MySQL.
* Created the `EmployeePayroll` JPA entity with:
  * Employee ID
  * Employee name
  * Email
  * Department
  * Basic salary
  * Allowances
  * Deductions
  * Net salary
* Created separate request and response DTOs:
  * `EmployeePayrollReqDTO`
  * `EmployeePayrollResDTO`
* Implemented `EmployeePayrollRepository` using `JpaRepository`.
* Added employee CRUD operations through `EmployeePayrollService` and `EmployeePayrollServiceImpl`.
* Implemented automatic net salary calculation:

  `Net Salary = Basic Salary + Allowances - Deductions`

* Created `EmployeePayrollController` with:
  * `POST /api/employees` — create employee
  * `GET /api/employees` — get all employees
  * `GET /api/employees/{id}` — get employee by ID
  * `PUT /api/employees/{id}` — update employee
  * `DELETE /api/employees/{id}` — delete employee
* Added `EmployeeNotFoundException` for missing employee records.
* Added `GlobalExceptionHandler` for:
  * Employee-not-found errors
  * Validation errors
  * General exceptions
* Returned structured `ErrorResponse` objects containing timestamp, status, error, message, and path.
* Configured MySQL database `employee_payroll_db` with JPA/Hibernate.
* Enabled SQL logging and formatted Hibernate SQL output.

#### 📂 Files

* `Day-12/employee_payroll_app/` (full Maven project)
  * `pom.xml`
  * `src/main/java/org/example/employee_payroll_app/`
    * `controller/EmployeePayrollController.java`
    * `dto/EmployeePayrollReqDTO.java`
    * `dto/EmployeePayrollResDTO.java`
    * `entity/EmployeePayroll.java`
    * `exception/EmployeeNotFoundException.java`
    * `exception/ErrorResponse.java`
    * `exception/GlobalExceptionHandler.java`
    * `repository/EmployeePayrollRepository.java`
    * `service/EmployeePayrollService.java`
    * `service/EmployeePayrollServiceImpl.java`
  * `src/main/resources/application.properties`
  * `src/test/java/org/example/employee_payroll_app/EmployeePayrollAppApplicationTests.java`

#### 📌 Status

**Completed ✅**

---

### ✅ Day 13 | 18-08-2026

#### 📚 Topics Covered

* Spring Security
* JWT-based Authentication
* Stateless Authentication
* JWT Authentication Filter
* `SecurityFilterChain`
* Password Hashing using `BCryptPasswordEncoder`
* User Registration and Login
* Role-based security foundations
* `SecurityContextHolder`
* `GrantedAuthority`
* JPA Entity and Repository for Users
* Authentication endpoint configuration
* Public vs authenticated endpoints
* Method-level security with `@EnableMethodSecurity`

#### 💻 Practical Work

* Started **fundoo-notes-app** as a Spring Boot security application.
* Created a `User` JPA entity containing:
  * User ID
  * Email
  * Password hash
  * Name
  * Role
* Created a `Role` enum with:
  * `USER`
  * `ADMIN`
* Implemented `UserRepository` with:
  * `findByEmail`
  * `existsByEmail`
* Implemented `UserService` for:
  * User registration
  * Password hashing with BCrypt
  * User login
  * JWT generation
* Implemented `JwtUtil` for:
  * Generating JWT tokens
  * Extracting user ID
  * Extracting email
  * Extracting role
  * Validating JWT tokens
* Implemented `JwtAuthenticationFilter` to:
  * Read the `Authorization: Bearer <token>` header
  * Validate the JWT
  * Extract the user ID and role
  * Create a Spring Security `Authentication`
  * Store authentication in `SecurityContextHolder`
* Configured `SecurityConfig` for stateless JWT authentication.
* Configured authentication rules so registration, login, password recovery endpoints, and H2 console are permitted while other requests require authentication.
* Enabled method-level security using `@EnableMethodSecurity`.

#### ⚠️ Notes

* The Day-13 source contains JWT utility/filter code and Spring Security configuration, but the provided `pom.xml` does not contain a JJWT dependency even though `JwtUtil` imports JJWT classes.
* The provided Day-13 `application.properties` only contains `spring.application.name`; the JWT properties referenced by the code (`jwt.secret` and `jwt.expiration-ms`) are not present in the supplied file.
* The supplied Day-13 project therefore represents the authentication/security implementation present in the ZIP, but additional configuration/dependencies may be required for the project to compile and run successfully.

#### 📂 Files

* `Day-13/fundoo_notes_app/` (Spring Boot Maven project)
  * `pom.xml`
  * `src/main/java/org/example/fundoo_notes_app/`
    * `config/JwtAuthenticationFilter.java`
    * `config/SecurityConfig.java`
    * `entity/Role.java`
    * `entity/User.java`
    * `repository/UserRepository.java`
    * `security/JwtUtil.java`
    * `service/UserService.java`
    * `FundooNotesAppApplication.java`
  * `src/main/resources/application.properties`
  * `src/test/java/org/example/fundoo_notes_app/FundooNotesAppApplicationTests.java`

#### 📌 Status

**Completed ✅**

---

### ✅ Day 14 | 19-08-2026

#### 📚 Topics Covered

* JWT Authorization and Role-Based Access Control
* User Roles using `USER` and `ADMIN`
* Adding Roles as JWT Claims
* Mapping JWT Roles to Spring Security `GrantedAuthority`
* `SimpleGrantedAuthority` and `ROLE_` Prefix
* Role-based Authentication using `SecurityContextHolder`
* Spring Security `SecurityFilterChain` with protected endpoints
* Password Recovery / Forgot Password Flow
* Password Reset using Short-Lived Tokens
* Single-Use Password Reset Tokens
* Sending Password Reset Emails using `JavaMailSender`
* Password Hashing using `BCryptPasswordEncoder`
* JPA Entity and Repository for Password Reset Tokens
* Centralized Exception Handling using `@RestControllerAdvice`
* Validation Error Handling with `MethodArgumentNotValidException`
* Custom `ResourceNotFoundException`
* Secure password recovery response to prevent email enumeration

#### 💻 Practical Work

* Continued the **fundoo-notes-app** Spring Boot security project from Day 13.
* Enhanced the `User` entity by adding a `Role` field with:

  * `USER`
  * `ADMIN`
* Updated JWT generation to include the user's role as a claim along with the user ID and email.
* Updated `JwtAuthenticationFilter` to:

  * Read the JWT from the `Authorization: Bearer <token>` header
  * Validate the token
  * Extract the user ID and role
  * Convert the role into a Spring Security `GrantedAuthority`
  * Store the authenticated user inside `SecurityContextHolder`
* Configured `SecurityConfig` for stateless JWT-based authorization.
* Kept authentication endpoints such as registration, login, forgot-password, and reset-password publicly accessible while protecting other endpoints.
* Enabled method-level security using `@EnableMethodSecurity`.
* Implemented the complete **Forgot Password / Reset Password** flow:

  * Created `PasswordResetToken` JPA entity
  * Added a unique reset token, user ID, expiry time, and used-status
  * Created `PasswordResetTokenRepository`
  * Implemented `PasswordResetService`
  * Generated random password reset tokens using `UUID`
  * Added configurable token expiry
  * Sent password reset links using `JavaMailSender`
  * Prevented password reset tokens from being reused
  * Validated token expiry before allowing a password change
  * Updated the user's password using BCrypt hashing
* Added new authentication endpoints:

  * `POST /auth/forgot-password` — request a password reset
  * `POST /auth/reset-password` — reset the password using a valid token
* Implemented `GlobalExceptionHandler` using `@RestControllerAdvice` for centralized error handling.
* Added handling for:

  * `IllegalArgumentException`
  * `ResourceNotFoundException`
  * `MethodArgumentNotValidException`
  * General exceptions
* Added `MessageResponse` DTO for clean API responses.
* Configured the project with Spring Boot Mail support for password recovery.

#### 📂 Files

* `Day-14/fundoo_notes_app/` (Spring Boot Maven project)

  * `pom.xml`
  * `src/main/java/org/example/fundoo_notes_app/`

    * `config/JwtAuthenticationFilter.java`
    * `config/SecurityConfig.java`
    * `controller/AuthController.java`
    * `dto/MessageResponse.java`
    * `entity/PasswordResetToken.java`
    * `entity/Role.java`
    * `entity/User.java`
    * `exception/GlobalExceptionHandler.java`
    * `exception/ResourceNotFoundException.java`
    * `repository/PasswordResetTokenRepository.java`
    * `repository/UserRepository.java`
    * `security/JwtUtil.java`
    * `service/PasswordResetService.java`
    * `service/UserService.java`
  * `src/main/resources/application.properties`
  * `src/test/java/org/example/fundoo_notes_app/FundooNotesAppApplicationTests.java`

#### ⚠️ Notes

* The Day-14 project contains the implementation for JWT role-based authorization and password recovery.
* Password reset tokens are designed to be short-lived and single-use.
* The password reset email uses a frontend reset URL placeholder (`your-frontend.example.com`), so it would need to be replaced with the actual frontend URL in a deployed application.
* The supplied `application.properties` only contains the application name and server port; JWT and email-related properties referenced by the code are not configured in the provided file.
* The project includes the required JJWT and Spring Boot Mail dependencies in `pom.xml`.

#### 📌 Status

**Completed ✅**

---

### ✅ Day 15 | 20-08-2026

#### 📚 Topics Covered

* Continued work on the **fundoo-notes-app** Spring Boot security project.
* Reviewed and maintained JWT-based authentication and authorization.
* Continued role-based security using `USER` and `ADMIN`.
* Continued password recovery and reset functionality.
* Continued centralized exception handling.
* Continued Spring Security configuration and protected API access.

#### 💻 Practical Work

* Continued the **fundoo-notes-app** project from Day 14.
* Maintained the JWT authentication flow using:

  * `JwtUtil`
  * `JwtAuthenticationFilter`
  * `SecurityConfig`
* Maintained role-based authorization using Spring Security authorities.
* Maintained the user authentication functionality with:

  * User registration
  * User login
  * BCrypt password hashing
  * JWT token generation and validation
* Maintained the forgot-password and password-reset functionality using:

  * `PasswordResetToken`
  * `PasswordResetTokenRepository`
  * `PasswordResetService`
  * `JavaMailSender`
* Maintained centralized exception handling through `GlobalExceptionHandler`.
* Continued using `ResourceNotFoundException` and validation exception handling.
* No new source-code changes are present in the Day-15 ZIP compared with the Day-14 version.

#### 📂 Files

* `Day-15/fundoo_notes_app/` (Spring Boot Maven project)

  * `pom.xml`
  * `src/main/java/org/example/fundoo_notes_app/`

    * `config/JwtAuthenticationFilter.java`
    * `config/SecurityConfig.java`
    * `controller/AuthController.java`
    * `dto/MessageResponse.java`
    * `entity/PasswordResetToken.java`
    * `entity/Role.java`
    * `entity/User.java`
    * `exception/GlobalExceptionHandler.java`
    * `exception/ResourceNotFoundException.java`
    * `repository/PasswordResetTokenRepository.java`
    * `repository/UserRepository.java`
    * `security/JwtUtil.java`
    * `service/PasswordResetService.java`
    * `service/UserService.java`
  * `src/main/resources/application.properties`
  * `src/test/java/org/example/fundoo_notes_app/FundooNotesAppApplicationTests.java`

#### ⚠️ Notes

* The Day-15 folder contains the same implementation as Day 14 in the supplied ZIP.
* No additional Day-15 Java classes, endpoints, dependencies, or configuration changes were found in the ZIP.
* Therefore, the Day-15 entry documents the continuation/review of the Day-14 implementation rather than claiming additional functionality that is not present in the source.

#### 📌 Status

**Completed ✅**

---

