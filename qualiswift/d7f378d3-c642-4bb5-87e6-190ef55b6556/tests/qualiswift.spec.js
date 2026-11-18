const { test, expect } = require('@playwright/test');

class LoginPage {
  constructor(page) {
    this.page = page;
    this.usernameInput = page.locator('#user-name');
    this.passwordInput = page.locator('#password');
    this.loginButton = page.locator('#login-button');
    this.errorMessage = page.locator('[data-test="error"]');
  }

  async goto() {
    await this.page.goto('/');
  }

  async login(username, password) {
    if (username !== null && username !== undefined) {
      await this.usernameInput.fill(username);
    }
    if (password !== null && password !== undefined) {
      await this.passwordInput.fill(password);
    }
    await this.loginButton.click();
  }

  async isErrorVisible() {
    return await this.errorMessage.isVisible();
  }

  async getErrorText() {
    return await this.errorMessage.textContent();
  }

  async passwordFieldType() {
    return await this.passwordInput.getAttribute('type');
  }
}

class ProductsPage {
  constructor(page) {
    this.page = page;
    this.title = page.locator('.title');
  }

  async isVisible() {
    return await this.title.isVisible();
  }

  async getTitleText() {
    return await this.title.textContent();
  }
}

// Valid users for successful login
const validUsers = ['standard_user', 'problem_user', 'performance_glitch_user'];

test.describe('SauceDemo Login Tests', () => {
  test.beforeEach(async ({ page }) => {
    const loginPage = new LoginPage(page);
    await loginPage.goto();
  });

  test('1. Login with valid username and password', async ({ page }) => {
    const loginPage = new LoginPage(page);
    const productsPage = new ProductsPage(page);
    await loginPage.login('standard_user', 'secret_sauce');
    await expect(productsPage.title).toHaveText('Products');
  });

  test('2. Login with invalid username', async ({ page }) => {
    const loginPage = new LoginPage(page);
    await loginPage.login('invalid_user', 'secret_sauce');
    await expect(loginPage.errorMessage).toBeVisible();
    await expect(page).toHaveURL(/saucedemo\.com\/$/);
  });

  test('3. Login with invalid password', async ({ page }) => {
    const loginPage = new LoginPage(page);
    await loginPage.login('standard_user', 'invalid_password');
    await expect(loginPage.errorMessage).toBeVisible();
    await expect(page).toHaveURL(/saucedemo\.com\/$/);
  });

  test('4. Login with empty username and password fields', async ({ page }) => {
    const loginPage = new LoginPage(page);
    await loginPage.usernameInput.fill('');
    await loginPage.passwordInput.fill('');
    await loginPage.loginButton.click();
    await expect(loginPage.errorMessage).toBeVisible();
    await expect(page).toHaveURL(/saucedemo\.com\/$/);
  });

  test('5. Login with empty username', async ({ page }) => {
    const loginPage = new LoginPage(page);
    await loginPage.usernameInput.fill('');
    await loginPage.passwordInput.fill('secret_sauce');
    await loginPage.loginButton.click();
    await expect(loginPage.errorMessage).toBeVisible();
    await expect(page).toHaveURL(/saucedemo\.com\/$/);
  });

  test('6. Login with empty password', async ({ page }) => {
    const loginPage = new LoginPage(page);
    await loginPage.usernameInput.fill('standard_user');
    await loginPage.passwordInput.fill('');
    await loginPage.loginButton.click();
    await expect(loginPage.errorMessage).toBeVisible();
    await expect(page).toHaveURL(/saucedemo\.com\/$/);
  });

  test('7. Login attempt by locked-out user', async ({ page }) => {
    const loginPage = new LoginPage(page);
    await loginPage.login('locked_out_user', 'secret_sauce');
    await expect(loginPage.errorMessage).toBeVisible();
    await expect(page).toHaveURL(/saucedemo\.com\/$/);
  });

  test('8. Password input masking verification', async ({ page }) => {
    const loginPage = new LoginPage(page);
    await loginPage.passwordInput.fill('secret_sauce');
    const typeAttr = await loginPage.passwordFieldType();
    expect(typeAttr).toBe('password');
  });

  test('9. Login with problem_user credentials', async ({ page }) => {
    const loginPage = new LoginPage(page);
    const productsPage = new ProductsPage(page);
    await loginPage.login('problem_user', 'secret_sauce');
    await expect(productsPage.title).toHaveText('Products');
  });

  test('10. Login with performance_glitch_user credentials', async ({ page }) => {
    const loginPage = new LoginPage(page);
    const productsPage = new ProductsPage(page);
    await loginPage.login('performance_glitch_user', 'secret_sauce');
    await expect(productsPage.title).toHaveText('Products', { timeout: 15000 });
  });
});
