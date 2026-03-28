# 🚀 Selenium TestNG Automation Framework

## 📌 Project Overview

This project is a **basic Selenium automation framework** built using **Java + TestNG** following the **Page Object Model (POM)** design pattern.

It demonstrates:

* UI automation for login functionality
* Positive and negative test scenarios
* Clean and maintainable test structure

---

## 🛠️ Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* IntelliJ IDEA

---

## 📁 Project Structure

```
src/
 ├── base/
 │     └── BaseTest.java
 │
 ├── pages/
 │     └── LoginPage.java
 │
 ├── tests/
 │     ├── LoginTest.java
 │     ├── InvalidLoginTest.java
 │     ├── LogOutTest.java
 │     ├── NavigationTest.java
 │     └── UIElementsTest.java
```

---

## 🧠 Framework Design

### 🔹 BaseTest

* Handles browser setup and teardown
* Uses TestNG annotations (`@BeforeMethod`, `@AfterMethod`)

### 🔹 Page Layer (POM)

* `LoginPage` contains all UI interactions
* Locators + reusable methods

### 🔹 Test Layer

* Contains actual test scenarios
* Uses page methods to perform actions

---

## ✅ Test Scenarios Covered

* ✔ Valid Login Test
* ✔ Invalid Login Test
* ✔ Logout Test
* ✔ UI Elements Validation (planned)
* ✔ Navigation Test (planned)

---

## ▶️ How to Run Tests

1. Clone the repository:

```
git clone https://github.com/vishwanathsv/selenium-framework.git
```

2. Open in IntelliJ IDEA

3. Run tests using:

* Right click → Run TestNG test
  OR
* Run via Maven:

```
mvn test
```

---

## 🔍 Sample Test Flow

1. Open login page
2. Enter username & password
3. Click login
4. Validate success/error message

---

## 📸 Application Under Test

Test site:

```
https://the-internet.herokuapp.com/login
```

---

## 🚀 Future Improvements

* Add BasePage (common reusable methods)
* Implement WebDriverWait (explicit waits)
* Add logging (Log4j)
* Generate reports (Extent Reports)
* Cross-browser testing
* CI/CD integration (Jenkins)

---

## 👨‍💻 Author

**Vishwanath S**

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
