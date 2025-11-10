-- Create DB and tables for OnlineBookStore
CREATE DATABASE IF NOT EXISTS OnlineBookStore;
USE OnlineBookStore;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(150) UNIQUE,
  password VARCHAR(255),
  is_admin TINYINT(1) DEFAULT 0
);

CREATE TABLE IF NOT EXISTS books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  author VARCHAR(255),
  price DOUBLE,
  image VARCHAR(255)
);

-- sample admin and books
INSERT INTO users (name,email,password,is_admin) VALUES
('Admin','admin@example.com','admin123',1)
ON DUPLICATE KEY UPDATE email=email;

INSERT INTO books (title,author,price,image) VALUES
('Java Basics','Author A',299.00,'images/java_basics.jpg'),
('DSA in Java','Author B',399.00,'images/dsa_java.jpg'),
('Spring Boot Guide','Author C',499.00,'images/spring_boot.jpg')
;
