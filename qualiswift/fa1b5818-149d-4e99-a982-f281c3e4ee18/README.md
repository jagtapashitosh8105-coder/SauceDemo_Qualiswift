# Qualiswift Selenium Java Tests for SauceDemo Login

## Overview
This project contains Selenium Java automated tests validating the login functionality of the SauceDemo web application.

## Requirements
- Java Development Kit (JDK) 8 or later
- Maven or other build system supporting Selenium Java dependencies
- Chrome browser installed

## Dependencies
The tests depend on:
- Selenium WebDriver

Add the following dependencies to your Maven `pom.xml` or download the jars manually:

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.9.0</version>
    </dependency>
</dependencies>
```

## Setup
1. Clone or download the repository.
2. Ensure Chrome browser is installed.
3. Configure the WebDriver for Chrome if needed (ChromeDriver must be accessible in your system PATH).
4. Build the project using your Java IDE or via command line.

## Running Tests
- The test entrypoints are static methods in `QualiswiftTests`.
- Use your test runner infrastructure that provides a `QSWebDriverRunner.Context` with a valid WebDriver instance.

## Notes
- Tests assume the application is accessible at https://www.saucedemo.com/
- Tests use exact `data-test` attribute selectors consistent with SauceDemo's design.
- Error message text values are asserted by presence, not by exact message text, due to unspecified exact error content.
- Tests throw `AssertionError` if assertions fail.

## Limitations
- Exact error message texts are not asserted because they were not provided in requirements.
- Timeout values are set based on typical waits but can be adjusted in the source code.

## Contact
For issues, please contact the test author.
