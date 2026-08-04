
-- Normalize orders(order_id, customer_name, customer_email,product_name, product_price, quantity) into 3NF

CREATE DATABASE IF NOT EXISTS order_management;
USE order_management;

CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    product_price DECIMAL(10,2) NOT NULL
);

CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE order_items (
    order_id INT,
    product_id INT,
    quantity INT NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);


-- Extend Health Clinic Schema

CREATE TABLE rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(10) UNIQUE NOT NULL,
    floor INT,
    room_type VARCHAR(50)
);

CREATE TABLE doctor_room (
    doctor_id INT,
    room_id INT,
    PRIMARY KEY (doctor_id, room_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
        ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
        ON DELETE CASCADE
);


/* Sample Data */

INSERT INTO rooms(room_number, floor, room_type)
VALUES
('R101',1,'General'),
('R102',1,'Cardiology'),
('R201',2,'Pediatrics');

INSERT INTO doctor_room(doctor_id, room_id)
VALUES
(1,1),
(1,2),
(2,3);



-- EXPLAIN Queries

-- Without Index
EXPLAIN
SELECT *
FROM appointments
WHERE status = 'Scheduled';


-- Single Column Index
CREATE INDEX idx_patient
ON appointments(patient_id);

EXPLAIN
SELECT *
FROM appointments
WHERE patient_id = 1;


-- Composite Index
CREATE INDEX idx_doctor_date
ON appointments(doctor_id, appointment_date);

EXPLAIN
SELECT *
FROM appointments
WHERE doctor_id = 1
AND appointment_date = '2026-08-05 10:00:00';


-- Index

CREATE INDEX idx_covering
ON appointments(doctor_id, appointment_date, status);

EXPLAIN
SELECT doctor_id,
       appointment_date,
       status
FROM appointments
WHERE doctor_id = 1;