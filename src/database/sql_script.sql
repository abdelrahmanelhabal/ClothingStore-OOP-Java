DROP DATABASE IF EXISTS ClothingStore;

CREATE DATABASE ClothingStore;

USE ClothingStore ;

CREATE TABLE Product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    stock INT NOT NULL CHECK (stock >= 0),
    category VARCHAR(30) NOT NULL ,
    price DECIMAL(15,2) NOT NULL CHECK (price >= 0),
    color VARCHAR(30) NOT NULL ,
    brand VARCHAR(30) NOT NULL ,
    material VARCHAR(30) NOT NULL
);

CREATE TABLE User (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(30) NOT NULL DEFAULT 'Customer'
);