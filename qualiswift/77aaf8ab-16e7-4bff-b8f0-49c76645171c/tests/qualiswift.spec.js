const { test, expect } = require('@playwright/test');

// POM class for SauceDemo Login Page
class SauceDemoLoginPage {
  constructor(page) {
    this.page = page;
    this.usernameInput = page.locator('#user-name');
    this.passwordInput = page.locator('#password');
    this.loginButton = page.locator('#login-button');
    this.errorMessageContainer = page.locator('div.error-message-container.error');
  }

  async goto() {
    await this.page.goto('/');
  }

  async login(username, password) {
    await this.usernameInput.fill(username);
    await this.passwordInput.fill(password);
    await this.loginButton.click();
  }

  async getErrorMessage() {
    return await this.errorMessageContainer.textContent();
  }

  async isPasswordMasked() {
    const type = await this.passwordInput.getAttribute('type');
    return type === 'password';
  }

  async currentUrl() {
    return this.page.url();
  }
}

const PRODUCTS_PAGE_URL = 'https://www.saucedemo.com/inventory.html';
const LOGIN_PAGE_URL = 'https://www.saucedemo.com/';

// 1. Login with valid username and password
 test('1. Login with valid username and password', async ({ page }) => {
  const loginPage = new SauceDemoLoginPage(page);
  await loginPage.goto();
  await loginPage.login('standard_user', 'secret_sauce');
  await expect(page).toHaveURL(PRODUCTS_PAGE_URL);
});

// 2. Login attempt with invalid username
 test('2. Login attempt with invalid username', async ({ page }) => {
  const loginPage = new SauceDemoLoginPage(page);
  await loginPage.goto();
  await loginPage.login('invalid_user', 'secret_sauce');
  const errorMsg = await loginPage.getErrorMessage();
  expect(errorMsg).toBeTruthy();
  await expect(page).toHaveURL(LOGIN_PAGE_URL);
});

// 3. Login attempt with invalid password
 test('3. Login attempt with invalid password', async ({ page }) => {
  const loginPage = new SauceDemoLoginPage(page);
  await loginPage.goto();
  await loginPage.login('standard_user', 'invalid_password');
  const errorMsg = await loginPage.getErrorMessage();
  expect(errorMsg).toBeTruthy();
  await expect(page).toHaveURL(LOGIN_PAGE_URL);
});

// 4. Login attempt with empty username and password fields
 test('4. Login attempt with empty username and password fields', async ({ page }) => {
  const loginPage = new SauceDemoLoginPage(page);
  await loginPage.goto();
  await loginPage.login('', '');
  const errorMsg = await loginPage.getErrorMessage();
  expect(errorMsg).toBeTruthy();
  await expect(page).toHaveURL(LOGIN_PAGE_URL);
});

// 5. Login attempt with locked-out user credentials
 test('5. Login attempt with locked-out user credentials', async ({ page }) => {
  const loginPage = new SauceDemoLoginPage(page);
  await loginPage.goto();
  await loginPage.login('locked_out_user', 'secret_sauce');
  const errorMsg = await loginPage.getErrorMessage();
  expect(errorMsg).toBeTruthy();
  await expect(page).toHaveURL(LOGIN_PAGE_URL);
});

// 6. Verify password masking in password field
 test('6. Verify password masking in password field', async ({ page }) => {
  const loginPage = new SauceDemoLoginPage(page);
  await loginPage.goto();
  await loginPage.passwordInput.focus();
  await loginPage.passwordInput.fill('secret_sauce');
  const masked = await loginPage.isPasswordMasked();
  expect(masked).toBe(true);
});

// 7. User remains on Login page after failed authentication
 test('7. User remains on Login page after failed authentication', async ({ page }) => {
  const loginPage = new SauceDemoLoginPage(page);
  await loginPage.goto();
  await loginPage.login('invalid_user', 'invalid_password');
  await expect(page).toHaveURL(LOGIN_PAGE_URL);
  const errorMsg = await loginPage.getErrorMessage();
  expect(errorMsg).toBeTruthy();
});

// 8. Login with performance glitch user credentials
 test('8. Login with performance glitch user credentials', async ({ page }) => {
  const loginPage = new SauceDemoLoginPage(page);
  await loginPage.goto();
  await loginPage.login('performance_glitch_user', 'secret_sauce');
  await expect(page).toHaveURL(PRODUCTS_PAGE_URL);
});

// 9. Login with problem user credentials
 test('9. Login with problem user credentials', async ({ page }) => {
  const loginPage = new SauceDemoLoginPage(page);
  await loginPage.goto();
  await loginPage.login('problem_user', 'secret_sauce');
  await expect(page).toHaveURL(PRODUCTS_PAGE_URL);
});
