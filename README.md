# RecipeShare - Online Recipe Sharing Platform

## Project Overview

RecipeShare is a Java-based Online Recipe Sharing Platform developed as a college project.

The platform allows users to discover recipes, share their own recipes, rate and review recipes, save recipes to their collection, and maintain browsing history.

An administrator can manage users and approve or reject submitted recipes.

---

## Technologies Used

* HTML
* Tailwind CSS
* Java
* Java Servlets
* JDBC
* MySQL
* Apache Tomcat
* VS Code

---

## Main Features

### User Features

* User Registration
* User Login
* Browse Recipes
* Search and Discover Recipes
* View Recipe Details
* Add New Recipes
* Rate Recipes
* Write Reviews
* Save Recipes
* View Saved Recipes
* View Browsing History

### Admin Features

* Admin Login
* View Pending Recipes
* Approve Recipes
* Reject Recipes
* Manage Users

---

## Java OOP Concepts Used

The project demonstrates the following Object-Oriented Programming concepts:

### Encapsulation

Private variables are used inside classes with public getter and setter methods.

Example:

```java
private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
```

### Inheritance

Classes such as `Admin`, `RecipeContributor`, and `RecipeExplorer` inherit from the `User` class.

```text
User
├── Admin
├── RecipeContributor
└── RecipeExplorer
```

### Polymorphism

The `displayDashboard()` method is overridden by different user types.

```java
@Override
public void displayDashboard() {
    System.out.println("Admin Dashboard");
}
```

### Abstraction

Interfaces are used to define common actions.

Examples:

* `RecipeActions`
* `RatingActions`

### Interface

`RecipeActions` provides methods for recipe management:

```java
void addRecipe();
void updateRecipe();
void deleteRecipe();
```

### Method Overriding

Child classes override methods inherited from the parent class.

### Method Overloading

Constructors with different parameters are used in the model classes.

### Exception Handling

Custom exception handling is implemented using:

```java
RecipeException
```

---

## Database

The project uses MySQL.

Database name:

```text
recipe_platform
```

Main tables:

* users
* recipes
* ratings
* collections
* browsing_history
* messages
* settings

---

## Project Structure

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

---

## How to Run the Project

### 1. Start MySQL

Make sure MySQL is running.

### 2. Start Apache Tomcat

Open the Tomcat `bin` folder and run:

```text
run-recipe.bat
```

Or from the VS Code terminal:

```powershell
cd "C:\Users\Raj Verma\Downloads\apache-tomcat-10.1.60-windows-x64\apache-tomcat-10.1.60\bin"
.\run-recipe.bat
```

### 3. Open the Application

Open:

```text
http://localhost:8080/RecipeSharing/
```

---

## Database Configuration

The database connection is configured in:

```text
src/com/recipe/util/DatabaseConnection.java
```

Update the MySQL password if required.

Example:

```java
private static final String URL =
    "jdbc:mysql://localhost:3306/recipe_platform";

private static final String USER = "root";

private static final String PASSWORD =
    "YOUR_PASSWORD";
```

---

## Admin Account

For testing:

```text
Email: admin@gmail.com
Password: admin123
```

---

## Project Objective

The main objective of RecipeShare is to provide a simple platform where users can share, discover, save, rate, and review recipes while demonstrating Java OOP concepts, JDBC database connectivity, MySQL, and Java Servlets.

---

## Project Type

**College Project**

Developed for educational purposes using Java, HTML, Tailwind CSS, JDBC, MySQL, and Apache Tomcat.
