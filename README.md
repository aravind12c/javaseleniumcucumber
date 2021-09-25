# Happeo Test Framework 


## Tech stack Used

Java, Cucumber, Selenium Webdriver, JUnit, Extent Report

## Prerequisites 

Use right Chromedriver as per your chrome version (src/main/resources -> driver -> chromedriver.exe)
Java 8 and above 
Any IDE 
    
## Project Setup 

- Driver capabilities -  \src\main\java\com.happeo.driverInit\
- Page Obejcts -  \src\main\java\com.happeo.pageObjects\
- Web Utilities - \src\main\java\com.happeo.webUtilities\
- Chrome driver - \src\main\resources\driver\
- Web Configs - \src\main\resources\driver\WebConfig
- Test Runner  - \src\test\java\com.happeo.runner\
- Step Definitions - \src\test\java\com.happeo.stepDefinitions
- Feature files - \src\test\resources\FeatureFile
- External Recources - \src\test\resources\External Resources
- Extent Report Properties  - \src\test\resources\
- Test Report - \reports

## Steps

- Download and Extract this project to your local 
- Import as a Maven project in any IDE
- Open TestRunner.java file, from "\src\test\java\runner"
- Now run as JUnit Test (Make sure to run in JUnit 4)

## Approach 

Below are the points considered while creating the framework

- Design pattern - Page object model
- Framework - Cucumber(For Test approach), Selenium Driver(For UI Automation), JUnit(Used some of its libraries)
- Language - Java
- Report - Extent