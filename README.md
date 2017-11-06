# automated-testing-yandex-market-example
An example project which shows the abilities of automated testing using JUnit4, Selenium WebDriver and Allure

DISCLAIMER
-----------
This project intentionally created as simple as possible to effectively explain the abilities of the tools.

General setup
----------
The example is set to use Internet Explorer driver, therefore some preinstallation steps required:
1. Download [InternetExplorerDriver](https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver)
2. Configure `System.setProperty("webdriver.ie.driver")` in source code `YandexMarketTest.java` - specify the full path to downloaded InternetExplorerDriver.exe
3. You will need [Maven](https://maven.apache.org/download.cgi) installed on your computer (to check if you have one, run "mvn -version" in command line)
4. Set `JAVA_HOME` system variable to your JDK (Java Developmen Kit) library. If you don't have the JDK yet, it's time to download one. 

NOTE – a path to JDK (not JRE) is requires, e.g. see example below:

![Set JAVA_HOME system variable](http://testercity.ru/wp-content/uploads/2017/11/Java8_JAVA_HOME.png)


Internet Explorer specific setup
----------
Before running any tests, in order to get the InternetExplorerDriver working, it needs to set same Security level in all zones. To do that follow the steps below:

1.	Open IE
2.	Go to Tools -> Internet Options -> Security
3.	Set all zones (Internet, Local intranet, Trusted sites, Restricted sites) to the same protected mode, enabled or disabled should not matter. I personally enabled protected mode for all zones and automated tests works just fine to me.

Finally, set Zoom level to 100% by right clicking on the gear located at the top right corner and enabling the status-bar. Default zoom level is now displayed at the lower right.

This setup required just once.

More info about these settings on the links:

* [Not able to launch IE browser using Selenium2 (Webdriver) with Java](https://stackoverflow.com/questions/14952348/not-able-to-launch-ie-browser-using-selenium2-webdriver-with-java)

* [Change the Protected Mode in all zones](https://github.com/seleniumQuery/seleniumQuery/wiki/seleniumQuery-and-IE-Driver#change-the-protected-mode-in-all-zones)

Internet Explore specific issues
----------
`.sendKeys()` method runs too slow on InternetExplorerDriver x64 bit version. The solution is simple - switch to 32bit version of driver fix the issue. And don't forget to update InternetExplorerDriver path in `System.setProperty("webdriver.ie.driver")`

More info about this issue on:  [WebDriver and IE10 very slow input](https://stackoverflow.com/questions/14461827/webdriver-and-ie10-very-slow-input)


Usage
----------
Import into your favourite IDE (e.g., Eclipse or IDEA) and run the project. It configured to trigger the JUnit tests and show you the results.

To just run the JUnit test, open command line, change dir to project folder where you have cloned this repository and where pom.xml is, then run following command:
```shell
mvn clean test
```
 -> Maven will clean up old precompiled code and artefacts, then run tests in browser


Once the tests have passed (or failed :), you can generate Allure report using one of the following command:
```shell
mvn allure:serve
```
 -> Report will be generated into temp folder. Web server with results will start and open in browser.
You can terminate the plugin with a ctrl-c in the terminal window where it is running.


```shell
mvn allure:report
```
 -> Report will be generated tо directory: target/site/allure-report/index.html

This plugin generates Allure report by [existing XML files](https://github.com/allure-framework/allure-core/wiki#gathering-information-about-tests) during the Maven build process.
More details on setup (for new projects only) https://docs.qameta.io/allure/2.0/#_maven_4


To conclude, all-in-one command to prepare maven project, then run tests, then build and show Allure report is:
```shell
mvn clean test allure:serve
```
_This should work in most cases._


Suggestions
----------
As a suggestion for dynamic-development projects I would recommend [jetty-maven-plugin](https://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html). 

I do not want to include this one in the example to keep it simple and include only necessary things for the work of a bundle Junit+Webdriver+Allure. But you can try.
