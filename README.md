# ClothingStore-OOP-Java

##  Project Overview

ClothingStore-OOP-Java is a Java console application simulating a clothing store system, built with Object-Oriented Programming (OOP) principles.

This eaturesrepository represents Version 1 (v1.0). Future releases will expand functionality, improve design, and incorporate advanced features.

##  Project Goals

* Strengthen understanding of Java OOP fundamentals
* Implement a modular, package-based project structure
* Simulate a basic e-commerce workflow
* Provide a scalable foundation for future enhancements

##  Project Structure

```
src/
│
├── app/
│   └── Main.java
├── cart/
│   ├── Cart.java
│   └── CartItem.java
├── products/
│   ├── Product.java
│   ├── Clothing.java
│   └── Accessory.java
└── user/
    ├── User.java
    └── Customer.java

```

##  Packages Description

###  Products

* **Product (abstract)** – Base class with fields: `id`, `name`, `price`, `stock`, `category`.
* **Clothing** – Extends `Product`; includes variations like size, color, brand.
* **Accessory** – Extends `Product`; represents items like watches, hats, and other accessories.

###  Cart

* **CartItem** – Represents an individual product in the cart with `product`, `size`, `color`, and `quantity`.
* **Cart** – Manages a collection of `CartItems`, supporting:

  * `addItem()`
  * `removeItem()`
  * `calculateTotal()`
  * `displayCart()`

###  User

* **User** – Base class for all users; designed for easy extension (e.g., admin, seller).
* **Customer** – Extends `User`; owns a cart and interacts with products.

##  How to Run

1. Clone the repository:

```bash
git clone https://github.com/your-username/ClothingStore-OOP-Java.git
```

2. Open the project in IntelliJ IDEA or any Java IDE.
3. Run `Main.java` to start the console application.

## 🛠 OOP Concepts Demonstrated

* **Encapsulation** – Protecting object data via getters/setters
* **Inheritance** – Extending base classes (`Product`, `User`)
* **Polymorphism** – Using overridden methods in child classes
* **Abstraction** – Abstract base classes and interfaces
* **Modular Packages** – Organized project structure for maintainability

##  Current Version

**v1.0 – Initial Release**

*  Basic product system
*  Cart functionality
*  Console-based testing

##  Planned for Version 2

* Admin role with management capabilities
* Product search and filtering
* Order management system
* File or database persistence
* Discount and promo code handling
* Enhanced exception handling and input validation

##  Notes

This project is intended for learning and practice purposes, ideal for students studying Java OOP, software design, and project structuring.
