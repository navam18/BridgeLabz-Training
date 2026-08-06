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
