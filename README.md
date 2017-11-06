# automated-testing-yandex-market-example
An example project which shows the abilities of automated testing using JUnit4, Selenium WebDriver and Allure

DISCLAIMER: 
-----------
This project intentionally created as simple as possible to effectively explain the abilities of the tools.

Setup:
----------
The example is set to use Internet Explorer driver, therefore some preinstallation steps required:
1. Download InternetExplorerDriver [https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver]
2. Configure System.setProperty("webdriver.ie.driver") in source code YandexMarketTest.java - specify the full path to downloaded InternetExplorerDriver.exe
3. You will need Maven installed on your computer (to check if you have one, run "mvn -version" in command line)
4. Set JAVA_HOME system variable to your JDK (Java Developmen Kit) library. If you don't have the JDK yet, it's time to download one. 

E.g., see the example for Windows:

![Set JAVA_HOME system variable](http://testercity.ru/wp-content/uploads/2017/11/Java8_JAVA_HOME.png)

Usage:
----------
Import into your favourite IDE (e.g., Eclipse or IDEA) and run the project. It configured to trigger the JUnit tests and show you the results.

Alternatively, and especially to get the Allure reports, open command line, change dir to where you have cloned this repository, then run following command:
```shell
mvn clean test allure:serve
```
