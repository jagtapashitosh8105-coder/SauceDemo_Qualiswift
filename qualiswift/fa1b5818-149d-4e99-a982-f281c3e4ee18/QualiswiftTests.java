import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QualiswiftTests {

    // Locators
    private static final By USERNAME_INPUT = By.cssSelector("[data-test='username']");
    private static final By PASSWORD_INPUT = By.cssSelector("[data-test='password']");
    private static final By LOGIN_BUTTON = By.cssSelector("[data-test='login-button']");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");
    private static final By PRODUCTS_TITLE = By.cssSelector("[data-test='title']");

    // Constants
    private static final String LOGIN_URL = "https://www.saucedemo.com/";
    private static final String PRODUCTS_PAGE_TITLE_TEXT = "Products";


    public static void test_001(QSWebDriverRunner.Context c) throws Exception {
        // 001. Login with valid username and password
        c.navigate("/");
        WebDriverWait wait = new WebDriverWait(c.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        c.driver.findElement(USERNAME_INPUT).clear();
        c.driver.findElement(USERNAME_INPUT).sendKeys("standard_user");

        c.driver.findElement(PASSWORD_INPUT).clear();
        c.driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");

        c.driver.findElement(LOGIN_BUTTON).click();

        // Assert user is redirected to Products page
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_TITLE));
        WebElement title = c.driver.findElement(PRODUCTS_TITLE);
        if (!PRODUCTS_PAGE_TITLE_TEXT.equals(title.getText())) {
            throw new AssertionError("Expected to be on the Products page after login");
        }
    }

    public static void test_002(QSWebDriverRunner.Context c) throws Exception {
        // 002. Login with invalid username
        c.navigate("/");
        WebDriverWait wait = new WebDriverWait(c.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        c.driver.findElement(USERNAME_INPUT).clear();
        c.driver.findElement(USERNAME_INPUT).sendKeys("invalid_user");

        c.driver.findElement(PASSWORD_INPUT).clear();
        c.driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");

        c.driver.findElement(LOGIN_BUTTON).click();

        // Assert error message is displayed and user remains on login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        WebElement error = c.driver.findElement(ERROR_MESSAGE);
        if (!error.isDisplayed()) {
            throw new AssertionError("Expected error message to be visible for invalid username");
        }

        // Check URL stays at login page
        if (!c.driver.getCurrentUrl().equals(LOGIN_URL)) {
            throw new AssertionError("Expected to remain on login page for invalid username");
        }
    }

    public static void test_003(QSWebDriverRunner.Context c) throws Exception {
        // 003. Login with invalid password
        c.navigate("/");
        WebDriverWait wait = new WebDriverWait(c.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        c.driver.findElement(USERNAME_INPUT).clear();
        c.driver.findElement(USERNAME_INPUT).sendKeys("standard_user");

        c.driver.findElement(PASSWORD_INPUT).clear();
        c.driver.findElement(PASSWORD_INPUT).sendKeys("invalid_password");

        c.driver.findElement(LOGIN_BUTTON).click();

        // Assert error message is displayed and user remains on login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        WebElement error = c.driver.findElement(ERROR_MESSAGE);
        if (!error.isDisplayed()) {
            throw new AssertionError("Expected error message to be visible for invalid password");
        }

        if (!c.driver.getCurrentUrl().equals(LOGIN_URL)) {
            throw new AssertionError("Expected to remain on login page for invalid password");
        }
    }

    public static void test_004(QSWebDriverRunner.Context c) throws Exception {
        // 004. Login with empty username and password
        c.navigate("/");
        WebDriverWait wait = new WebDriverWait(c.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        c.driver.findElement(USERNAME_INPUT).clear();
        c.driver.findElement(PASSWORD_INPUT).clear();

        c.driver.findElement(LOGIN_BUTTON).click();

        // Assert error message is displayed and user remains on login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        WebElement error = c.driver.findElement(ERROR_MESSAGE);
        if (!error.isDisplayed()) {
            throw new AssertionError("Expected error message to be visible for empty credentials");
        }

        if (!c.driver.getCurrentUrl().equals(LOGIN_URL)) {
            throw new AssertionError("Expected to remain on login page for empty credentials");
        }
    }

    public static void test_005(QSWebDriverRunner.Context c) throws Exception {
        // 005. Login with locked-out user credentials
        c.navigate("/");
        WebDriverWait wait = new WebDriverWait(c.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        c.driver.findElement(USERNAME_INPUT).clear();
        c.driver.findElement(USERNAME_INPUT).sendKeys("locked_out_user");

        c.driver.findElement(PASSWORD_INPUT).clear();
        c.driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");

        c.driver.findElement(LOGIN_BUTTON).click();

        // Assert error message is displayed and user remains on login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        WebElement error = c.driver.findElement(ERROR_MESSAGE);
        if (!error.isDisplayed()) {
            throw new AssertionError("Expected error message to be visible for locked-out user");
        }

        if (!c.driver.getCurrentUrl().equals(LOGIN_URL)) {
            throw new AssertionError("Expected to remain on login page for locked-out user");
        }
    }

    public static void test_006(QSWebDriverRunner.Context c) throws Exception {
        // 006. Verify password field masks input
        c.navigate("/");
        WebDriverWait wait = new WebDriverWait(c.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
        WebElement passwordField = c.driver.findElement(PASSWORD_INPUT);

        // Verify that the input type is 'password'
        String typeAttribute = passwordField.getAttribute("type");
        if (!"password".equals(typeAttribute)) {
            throw new AssertionError("Password field does not mask input (input type is not 'password')");
        }
    }

    public static void test_007(QSWebDriverRunner.Context c) throws Exception {
        // 007. Login with valid username and password for problem user
        c.navigate("/");
        WebDriverWait wait = new WebDriverWait(c.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        c.driver.findElement(USERNAME_INPUT).clear();
        c.driver.findElement(USERNAME_INPUT).sendKeys("problem_user");

        c.driver.findElement(PASSWORD_INPUT).clear();
        c.driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");

        c.driver.findElement(LOGIN_BUTTON).click();

        // Assert user is redirected to Products page
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_TITLE));
        WebElement title = c.driver.findElement(PRODUCTS_TITLE);
        if (!PRODUCTS_PAGE_TITLE_TEXT.equals(title.getText())) {
            throw new AssertionError("Expected to be on the Products page after login with problem_user");
        }
    }

    public static void test_008(QSWebDriverRunner.Context c) throws Exception {
        // 008. Login with valid username and password for performance glitch user
        c.navigate("/");
        WebDriverWait wait = new WebDriverWait(c.driver, Duration.ofSeconds(20)); // extra wait time for performance glitch

        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        c.driver.findElement(USERNAME_INPUT).clear();
        c.driver.findElement(USERNAME_INPUT).sendKeys("performance_glitch_user");

        c.driver.findElement(PASSWORD_INPUT).clear();
        c.driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");

        c.driver.findElement(LOGIN_BUTTON).click();

        // Assert user is redirected to Products page
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_TITLE));
        WebElement title = c.driver.findElement(PRODUCTS_TITLE);
        if (!PRODUCTS_PAGE_TITLE_TEXT.equals(title.getText())) {
            throw new AssertionError("Expected to be on the Products page after login with performance_glitch_user");
        }
    }

    public static void test_009(QSWebDriverRunner.Context c) throws Exception {
        // 009. Attempt login with username only filled
        c.navigate("/");
        WebDriverWait wait = new WebDriverWait(c.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        c.driver.findElement(USERNAME_INPUT).clear();
        c.driver.findElement(USERNAME_INPUT).sendKeys("standard_user");

        c.driver.findElement(PASSWORD_INPUT).clear();

        c.driver.findElement(LOGIN_BUTTON).click();

        // Assert error message is displayed about password required
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        WebElement error = c.driver.findElement(ERROR_MESSAGE);
        if (!error.isDisplayed()) {
            throw new AssertionError("Expected error message to be visible for password empty");
        }

        if (!c.driver.getCurrentUrl().equals(LOGIN_URL)) {
            throw new AssertionError("Expected to remain on login page for missing password");
        }
    }

    public static void test_010(QSWebDriverRunner.Context c) throws Exception {
        // 010. Attempt login with password only filled
        c.navigate("/");
        WebDriverWait wait = new WebDriverWait(c.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        c.driver.findElement(USERNAME_INPUT).clear();

        c.driver.findElement(PASSWORD_INPUT).clear();
        c.driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");

        c.driver.findElement(LOGIN_BUTTON).click();

        // Assert error message is displayed about username required
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        WebElement error = c.driver.findElement(ERROR_MESSAGE);
        if (!error.isDisplayed()) {
            throw new AssertionError("Expected error message to be visible for username empty");
        }

        if (!c.driver.getCurrentUrl().equals(LOGIN_URL)) {
            throw new AssertionError("Expected to remain on login page for missing username");
        }
    }

}
