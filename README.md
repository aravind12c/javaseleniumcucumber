# Happeo Test Framework 


## Tech stack Used
Java, Cucumber, Selenium Webdriver, JUnit, Extent Report

## Prerequisites 
- Use right Chromedriver as per your chrome version (src/main/resources -> driver -> chromedriver.exe)
- Java 8 and above 
- Any IDE 
- For Cucumber's actual flavour, install a plugin for cucumber in IDE and convert project into cucumber project
    
## Project Setup 
- Driver capabilities : \src\main\java\com.happeo.driverInit\
- Page Obejcts :        \src\main\java\com.happeo.pageObjects\
- Web Utilities :       \src\main\java\com.happeo.webUtilities\
- Chrome driver :       \src\main\resources\driver\
- Web Configs :         \src\main\resources\driver\WebConfig
- Test Runner  :        \src\test\java\com.happeo.runner\
- Step Definitions :    \src\test\java\com.happeo.stepDefinitions
- Feature files :       \src\test\resources\FeatureFile
- External Recources :  \src\test\resources\External Resources
- Extent Properties :   \src\test\resources\
- Test Report :         \reports

## Pre-Steps
- If you want to update URL and Credentials, please open config.properties from Web Config and update it.

## Steps
- Download and Extract this project to your local or git clone https://github.com/aravind12c/happeotestframework.git
- Import as a Maven project in any IDE
- Open TestRunner.java file, from "\src\test\java\runner"
- Now run as JUnit Test (Make sure to run in JUnit 4)

## Approach 
Below are the points considered while creating the framework
- Design pattern - Page object model
- Framework - Cucumber(For Test approach), Selenium Driver(For UI Automation), JUnit(Used some of its libraries)
- Language - Java
- Report - Extent

## Future Implementation/Improvements
- Update the Framework to run in other browsers like Firefox, Opera, Edge, Safari
- Implement docker containerization, so that we can run in remote containers, which will save time and accident interruptions
- Implement selenoid or any other paid cloud platforms to do Compatibility testing.
- Improve the framework to test API Scenarios.
