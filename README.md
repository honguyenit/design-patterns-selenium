# Common Design Patterns in Selenium with Use Cases

## Overview

This project demonstrates the application of four common design patterns in test automation and their use in solving specific problems. By using the JuiceShop application, this project illustrates practical implementations of these design patterns to enhance the effectiveness and maintainability of automated tests.

## Design Patterns Covered

1. **Page Object Model (POM) Pattern**: Encapsulates interactions with web pages into page object classes, providing a clear and maintainable interface for test scripts to interact with the UI elements.

2. **Factory Pattern**: Provides a method for creating objects in a superclass but allows subclasses to alter the type of objects that will be created. Useful for creating instances of different page objects or components based on context.

3. **Strategy Pattern**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern is used to switch between different test strategies or algorithms dynamically.

4. **Template Method Pattern**: Defines the skeleton of an algorithm in a base class but allows subclasses to override specific steps of the algorithm without changing its structure. Useful for creating reusable test workflows with customizable steps.

## Prerequisites

Before running the tests, you need to set up the JuiceShop application locally. Follow these steps:

### Clone the JuiceShop Repository
   Clone the JuiceShop repository from GitHub:

```bash
git clone https://github.com/juice-shop/juice-shop.git
```

### Install Dependencies

Navigate to the JuiceShop directory and install the required dependencies:

```bash
cd juice-shop
npm install
```

### Start the JuiceShop Application
```bash
npm start
```

The JuiceShop application will be available at http://localhost:3000.

### Register an Account
Register an account on the JuiceShop site with the following credentials:

Email: qatest@gmail.com
Password: qatest

### Project Structure
The project is organized as follows:

- src/main/java: Contains the Java source code implementing the design patterns.
- src/test/java: Contains the automated tests demonstrating the application of design patterns to solve specific problems.

### Running the Tests
Ensure the JuiceShop application is running locally, then execute the tests using your preferred Java testing framework (e.g., JUnit, TestNG).