# 🍴 RecipeShare - Online Recipe Sharing Platform

## 📌 Project Overview

**RecipeShare** is a Java-based Online Recipe Sharing Platform developed as a college project.

The platform allows users to register, log in, discover recipes, view recipe details, share recipes, rate and review recipes, save recipes, and maintain browsing history.

An administrator can review submitted recipes and approve or reject them before they are published.

---

## 🎯 Project Objective

The main objective of this project is to develop a simple recipe-sharing web application while demonstrating:

* Java Object-Oriented Programming
* Java Servlets
* JDBC database connectivity
* MySQL database management
* HTML and Tailwind CSS
* Apache Tomcat

---

## 🛠️ Technologies Used

| Technology         | Purpose                 |
| ------------------ | ----------------------- |
| HTML               | Web pages and forms     |
| Tailwind CSS       | User interface styling  |
| Java               | Backend development     |
| Java Servlets      | Handling web requests   |
| JDBC               | Database connectivity   |
| MySQL              | Data storage            |
| Apache Tomcat 10.1 | Web server              |
| VS Code            | Development environment |

---

## ✨ Features

### 👤 User Features

* User Registration
* User Login
* Discover Recipes
* View Recipe Details
* Add New Recipes
* Submit Recipes for Admin Approval
* Rate Recipes
* Add Reviews
* Save Recipes
* View Saved Recipes
* View Browsing History

### 👨‍💼 Admin Features

* Admin Dashboard
* View Submitted Recipes
* Approve Recipes
* Reject Recipes

---

## 🧠 Java OOP Concepts Used

This project demonstrates important Object-Oriented Programming concepts.

### 1. Encapsulation

Private data members are accessed using getter and setter methods.

```java
private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
```

### 2. Inheritance

Different user types inherit from the `User` class.

```text
User
├── Admin
├── RecipeContributor
└── RecipeExplorer
```

### 3. Polymorphism

The `displayDashboard()` method is overridden by different child classes.

```java
@Override
public void displayDashboard() {
    System.out.println("Admin Dashboard");
}
```

### 4. Abstraction

Interfaces are used to define common operations.

Examples:

* `RecipeActions`
* `RatingActions`

### 5. Interface

`RecipeActions` defines recipe-related operations:

```java
void addRecipe();
void updateRecipe();
void deleteRecipe();
```

### 6. Method Overriding

Child classes override methods inherited from the parent class.

### 7. Constructor Overloading

Multiple constructors with different parameter lists are used in model classes.

### 8. Exception Handling

A custom exception class is included:

```text
RecipeException
```

---

## 🗄️ Database

The project uses **MySQL**.

### Database Name

```text
recipe_platform
```

### Main Tables

* `users`
* `recipes`
* `ratings`
* `collections`
* `browsing_history`
* `messages`
* `settings`

---

## 📂 Project Structure

```text
OnlineRecipePlatform/
│
├── src/
│   └── com/
│       └── recipe/
│           ├── model/
│           ├── interfaces/
│           ├── dao/
│           ├── exception/
│           ├── util/
│           └── servlet/
│
├── webapp/
│   ├── index.html
│   ├── register.html
│   ├── recipes.html
│   ├── recipe-details.html
│   ├── dashboard.html
│   ├── admin-dashboard.html
│   ├── add-recipe.html
│   └── WEB-INF/
│       ├── web.xml
│       ├── classes/
│       └── lib/
│
├── lib/
│   └── mysql-connector-j-26.7.0.jar
│
├── database/
│   └── recipe_platform.sql
│
└── README.md
```

---

## ⚙️ Setup and Run

### 1. Install Required Software

Make sure the following are installed:

* Java JDK
* MySQL
* Apache Tomcat 10.1
* VS Code

### 2. Create the Database

Create the MySQL database:

```sql
CREATE DATABASE recipe_platform;
```

Then create the required tables using:

```text
database/recipe_platform.sql
```

### 3. Configure MySQL Connection

Open:

```text
src/com/recipe/util/DatabaseConnection.java
```

Update your local MySQL password:

```java
private static final String PASSWORD = "YOUR_PASSWORD";
```

**Do not upload your real MySQL password to GitHub.**

### 4. Start Apache Tomcat

Start Tomcat from its `bin` folder.

The application runs at:

```text
http://localhost:8080/RecipeSharing/
```

---

## 🔐 Test Admin Account

For local testing:

```text
Email: admin@gmail.com
Password: admin123
```

> This account is intended only for local college-project testing.

---

## 🔌 JDBC Connection

The application connects to MySQL using JDBC.

Example connection:

```text
jdbc:mysql://localhost:3306/recipe_platform
```

The MySQL Connector/J driver is used for database connectivity.

---

## 🌐 Application Pages

The project contains pages such as:

* Login
* Registration
* Recipe Discovery
* Recipe Details
* User Dashboard
* Add Recipe
* Admin Dashboard

---

## 📚 Academic Purpose

This project was developed for educational purposes to demonstrate the integration of:

**Frontend + Java Backend + JDBC + MySQL + Object-Oriented Programming**

---

## 👨‍💻 Project Type

**College Project**

Built using Java, HTML, Tailwind CSS, JDBC, MySQL, and Apache Tomcat.

---

## 📄 License

This project is created for educational and academic purposes.
