# 🚀 Selenium TestNG Automation Framework

## 📌 Project Overview

This project is a **Selenium automation framework** built using **Java + TestNG**, following the **Page Object Model (POM)** design pattern.

It demonstrates:

* UI automation for login and product pages
* Data-driven testing (Properties, JSON, Excel)
* Scalable and maintainable framework structure

---

## 🛠️ Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* IntelliJ IDEA
* Apache POI (Excel handling)
* Gson (JSON handling)

---

## 📁 Project Structure

```
src/
├── main/
│   └── java/
│       ├── base/
│       │     └── BaseTest.java
│       ├── pages/
│       │     ├── LoginPage.java
│       │     └── InventoryPage.java
│       └── utils/
│             ├── ConfigReader.java
│             └── JsonUtils.java
│
├── test/
│   ├── java/
│   │   └── tests/
│   │       ├── LoginTest.java
│   │       └── products/
│   │           └── ProductsTestCase.java
│   │
│   └── resources/
│       ├── config.properties
│       └── testdata/
│           ├── users.json
│           └── testdata.xlsx
```

---

## 🧠 Framework Design

### 🔹 BaseTest

* Handles browser setup and teardown
* Reads configuration from `config.properties`
* Performs common login setup

---

### 🔹 Page Layer (POM)

* `LoginPage` → handles login actions
* `InventoryPage` → handles product-related actions

Includes:

* Locators
* Reusable methods
* Page-specific validations

---

### 🔹 Utils Layer

* `ConfigReader` → reads data from properties file
* `JsonUtils` → reads test data from JSON
* (Future) `ExcelUtils` → reads Excel test data

---

### 🔹 Test Layer

* Contains actual test scenarios
* Uses Page classes for actions
* Uses assertions for validations

---

## ✅ Test Scenarios Covered

### 🔐 Login

* ✔ Valid Login
* ✔ Invalid Login
* ✔ Logout

---

### 🛒 Products / Inventory

* ✔ Verify product page loads
* ✔ Verify products are listed
* ✔ Validate product details
* ✔ Sort by price (Low → High)
* ✔ Add product to cart
* ✔ Remove product from cart
* ✔ Cart navigation
* ✔ Product detail navigation

---

## ▶️ How to Run Tests

1. Clone the repository:

```
git clone https://github.com/vishwanathsv/selenium-framework.git
```

2. Open in IntelliJ IDEA

3. Run tests:

* Right click → Run TestNG test
  OR

```
mvn test
```

---

## 🔍 Sample Test Flow

1. Open application URL
2. Login using credentials from config file
3. Perform actions (add/remove/sort products)
4. Validate expected behavior

---

## 📸 Application Under Test

* https://www.saucedemo.com
* https://the-internet.herokuapp.com/login

---

## 🚀 Future Improvements

* Add `BasePage` for common methods
* Implement Explicit Waits (WebDriverWait)
* Add logging (Log4j)
* Integrate Extent Reports
* Cross-browser execution
* CI/CD integration (Jenkins)

---

## 👨‍💻 Author

**Vishwanath S**

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
