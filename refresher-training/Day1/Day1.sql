-- CREATE DATABASE
CREATE DATABASE IF NOT EXISTS health_clinic_db;

-- USE DATABASE
USE health_clinic_db;

-- SHOW DATABASES
SHOW DATABASES;

-- CREATE PATIENTS TABLE
CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    gender ENUM('Male','Female','Other'),
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100),
    registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- CREATE DOCTORS TABLE
CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialization VARCHAR(100),
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100)
);

-- INSERT SINGLE RECORD
INSERT INTO patients
(first_name,last_name,date_of_birth,gender,phone_number,email)
VALUES
('Rahul','Sharma','1998-06-18','Male','9876543201','rahul@gmail.com');

-- INSERT MULTIPLE RECORDS
INSERT INTO patients
(first_name,last_name,date_of_birth,gender,phone_number,email)
VALUES
('Priya','Verma','1999-11-02','Female','9876543202','priya@gmail.com'),
('Amit','Singh','2000-02-15','Male','9876543203','amit@gmail.com');

-- INSERT DOCTORS
INSERT INTO doctors
(first_name,last_name,specialization,phone_number,email)
VALUES
('Neha','Kapoor','Cardiology','9123456701','neha@clinic.com'),
('Rohit','Joshi','Orthopedics','9123456702','rohit@clinic.com');

-- VIEW DATA
SELECT * FROM patients;
SELECT * FROM doctors;

-- ALTER TABLE - ADD COLUMN
ALTER TABLE patients
ADD COLUMN address VARCHAR(150);

-- ALTER TABLE - MODIFY COLUMN
ALTER TABLE patients
MODIFY phone_number VARCHAR(20);

-- ALTER TABLE - RENAME COLUMN
ALTER TABLE patients
CHANGE address residential_address VARCHAR(150);

-- ALTER TABLE - DROP COLUMN
ALTER TABLE patients
DROP COLUMN residential_address;

-- UPDATE RECORD
UPDATE patients
SET email='rahul.sharma@gmail.com'
WHERE patient_id=1;

-- DELETE RECORD
DELETE FROM patients
WHERE patient_id=3;

-- VERIFY RECORD
SELECT * FROM patients;

-- CREATE SPECIALIZATIONS TABLE
CREATE TABLE specializations(
    specialization_id INT AUTO_INCREMENT PRIMARY KEY,
    specialization_name VARCHAR(100),
    description VARCHAR(200)
);

-- INSERT SPECIALIZATIONS
INSERT INTO specializations(specialization_name,description)
VALUES
('Cardiology','Heart Specialist'),
('Neurology','Brain Specialist'),
('Dermatology','Skin Specialist');

-- CREATE APPOINTMENTS TABLE
CREATE TABLE appointments(
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE
);

-- INSERT APPOINTMENTS
INSERT INTO appointments(patient_id,doctor_id,appointment_date)
VALUES
(1,1,'2026-08-10'),
(2,2,'2026-08-11'),
(1,2,'2026-08-12');

-- ALTER APPOINTMENTS TABLE
ALTER TABLE appointments
ADD COLUMN appointment_status VARCHAR(30);

ALTER TABLE appointments
DROP COLUMN appointment_status;

-- UPDATE APPOINTMENT
UPDATE appointments
SET appointment_date='2026-08-20'
WHERE appointment_id=2;

-- DELETE APPOINTMENT
DELETE FROM appointments
WHERE appointment_id=3;

-- VERIFY DATA
SELECT * FROM appointments;

-- TRANSACTION CONTROL
START TRANSACTION;

UPDATE patients
SET phone_number='9998887777'
WHERE patient_id=1;

ROLLBACK;

START TRANSACTION;

UPDATE patients
SET phone_number='9998887777'
WHERE patient_id=1;

COMMIT;

-- CREATE USER
CREATE USER IF NOT EXISTS 'clinic_user'@'localhost'
IDENTIFIED BY 'Clinic@123';

-- GRANT PERMISSIONS
GRANT
SELECT,
INSERT,
UPDATE,
DELETE
ON health_clinic_db.*
TO 'clinic_user'@'localhost';

FLUSH PRIVILEGES;

-- REVOKE PERMISSION
REVOKE DELETE
ON health_clinic_db.*
FROM 'clinic_user'@'localhost';

FLUSH PRIVILEGES;

-- SHOW DATABASE VERSION
SELECT VERSION();

-- EXPLAIN QUERY
EXPLAIN
SELECT *
FROM patients
WHERE patient_id=1;

-- SHOW ACTIVE CONNECTIONS
SHOW PROCESSLIST;

-- SHOW WARNINGS
SHOW WARNINGS;

-- ENABLE GENERAL QUERY LOG
SET GLOBAL general_log='ON';

SET GLOBAL general_log_file='C:/ProgramData/MySQL/MySQL Server 8.0/Data/query.log';

-- TRIGGER AN ERROR
SELECT * FROM unknown_table;

-- RENAME TABLE
-- RENAME TABLE patients TO patient_master;

-- RENAME TABLE BACK
-- RENAME TABLE patient_master TO patients;

-- TRUNCATE TABLE
-- TRUNCATE TABLE appointments;

-- DROP TABLES
-- DROP TABLE appointments;
-- DROP TABLE specializations;
-- DROP TABLE doctors;
-- DROP TABLE patients;

-- DROP DATABASE
-- DROP DATABASE health_clinic_db;