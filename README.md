# 'Stellar Burgers' web-ui-tests

WEB UI TESTING A TRAINING SERVICE
[**«STELLAR BURGERS»**](https://stellarburgers.nomoreparties.site)


## Description

Project uses
- Java 11
- JUnit 4.13.2
- Selenium 4.16.0

Supported browsers
- Google Chrome
- Yandex Browser
- Microsoft Edge
- Mozilla Firefox


## Repository cloning
```shell
git clone https://github.com/Sergey8193/Diplom_3.git
```


## Running auto tests

**Running tests and generating allure report** (```mvn clean test```)

Report folder: ```target/allure-results```

When using the "browser" system property in a non-parameterized test, 
the test will be executed for the specified browser
List of supported "browser" values: ```'crome', 'yandex', 'edge', 'firefox' ```

For example (```mvn clean test -Dtest=OrderHistoryPageTest -Dbrowser=edge```)

**Launching web server with a report** (```mvn allure:serve```)



## Project Tree

```
pom.xml
README.md
.gitignore
src
|-- main
|   |-- java
|   |   |-- praktikum
|   |   |   |-- stellarburgers
|   |   |   |   |-- model
|   |   |   |   |   |-- mock
|   |   |   |   |   |   |-- BurgerDataGenerator.java
|   |   |   |   |   |   |-- StabGenerator.java
|   |   |   |   |   |-- Bun.java
|   |   |   |   |   |-- Burger.java
|   |   |   |   |   |-- Database.java
|   |   |   |   |   |-- Ingredient.java
|   |   |   |   |   |-- IngredientType.java
|   |   |   |   |-- Praktikum.java
|-- test
|   |-- java
|   |   |-- praktikum
|   |   |   |-- stellarburgers
|   |   |   |   |-- pom
|   |   |   |   |   |-- base
|   |   |   |   |   |   |-- BaseTest.java
|   |   |   |   |   |   |-- BaseWeb.java
|   |   |   |   |   |-- page
|   |   |   |   |   |   |-- LoginPageParamTest.java
|   |   |   |   |   |   |-- LoginPageTest.java
|   |   |   |   |   |   |-- MainPageBurgerAssemblyParamTest.java
|   |   |   |   |   |   |-- MainPageBurgerAssemblyTest.java
|   |   |   |   |   |   |-- MainPageConstructorSectionParamTest.java
|   |   |   |   |   |   |-- MainPageConstructorSectionTest.java
|   |   |   |   |   |   |-- OrderHistoryPageParamTest.java
|   |   |   |   |   |   |-- OrderHistoryPageTest.java
|   |   |   |   |   |   |-- ProfilePageParamTest.java
|   |   |   |   |   |   |-- ProfilePageTest.java
|   |   |   |   |   |   |-- RegisterPageParamTest.java
|   |   |   |   |   |   |-- RegisterPageTest.java
|   |   |   |   |-- WebUiTestLauncher.java
```


## Completed tasks

Created auto Web UI tests of basic functionality:
- user registration
- user authorization
- creating an order
- placing an order on the service
