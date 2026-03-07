# ClothingStore-OOP-Java 

## Project Overview

ClothingStore-OOP-Java is a Java console application that simulates a
clothing store system using Object-Oriented Programming (OOP)
principles.

Version **2.0** expands the original project by introducing **database
integration, DAO pattern, and a service layer architecture**.\
The application now uses **MySQL with JDBC** to store and retrieve
product and user data.

## What's New in Version 2

-   MySQL database integration
-   JDBC-based database connection
-   DAO (Data Access Object) pattern
-   Service layer for business logic
-   External configuration using `config.properties`
-   Improved project structure with layered architecture
-   Custom DAO exception handling

## Project Structure

    src/
    │
    ├── app/
    │   └── Main.java
    │
    ├── dao/
    │   ├── exception/
    │   │   └── DaoException.java
    │   │
    │   ├── interfaces/
    │   │   ├── ProductDAO.java
    │   │   └── UserDAO.java
    │   │
    │   └── impl/
    │       ├── ProductDAOImpl.java
    │       └── UserDAOImpl.java
    │
    ├── database/
    │   ├── DBConnection.java
    │   └── sql_script.sql
    │
    ├── models/
    │   ├── products/
    │   │   ├── Product.java
    │   │   ├── Clothing.java
    │   │   └── Accessory.java
    │   │
    │   └── user/
    │       ├── User.java
    │       ├── Customer.java
    │       └── Admin.java
    │
    ├── service/
    │   ├── ProductService.java
    │   └── UserService.java
    │
    └── resources/
        └── config.properties

## How to Run

### 1. Clone the Repository

``` bash
git clone https://github.com/your-username/ClothingStore-OOP-Java.git
```

### 2. Open the Project

Open the project in **IntelliJ IDEA**.

    File → Open → Select the project folder

### 3. Configure Libraries in IntelliJ IDEA

This project uses external `.jar` libraries located in the **libs**
folder:

-   mysql-connector-java-5.1.49.jar
-   jbcrypt-0.4.jar

Steps to add them:

1.  Go to **File → Project Structure**
2.  Select **Modules**
3.  Open the **Dependencies** tab
4.  Click **+**
5.  Choose **JARs or Directories**
6.  Select the **libs** folder
7.  Add both `.jar` files
8.  Click **Apply → OK**


### 4. Setup Database

Install MySQL and create the database:

``` sql
CREATE DATABASE clothing_store;
```

Then run the SQL script located in:

    database/sql_script.sql


### 5. Configure Database Connection

Edit:

    resources/config.properties

Example configuration:

    db.url=jdbc:mysql://localhost:3306/clothing_store
    db.user=root
    db.password=yourpassword


### 6. Run the Application

Run the main class:

    app/Main.java

The console application will start.

## Technologies Used

-   Java
-   JDBC
-   MySQL
-   Object-Oriented Programming
-   DAO Design Pattern
-   Layered Architecture


## OOP Concepts Demonstrated

-   **Encapsulation** -- using getters and setters
-   **Inheritance** -- extending base classes like `Product` and `User`
-   **Polymorphism** -- DAO implementations and overridden methods
-   **Abstraction** -- abstract classes and interfaces
-   **Separation of Concerns** -- models, DAO, services, and database
    layers

## Current Version

**v2.0 -- Database Integrated Version**

Features include: - MySQL persistence - DAO layer - Service layer -
Configurable database connection - Improved error handling

## Notes

This project is intended for learning **Java backend architecture and
OOP design principles** and demonstrates how a simple OOP project can
evolve into a scalable layered system.
