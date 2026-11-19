# SauceDemo Login Tests with Playwright

This project contains Playwright tests for the SauceDemo application login page.

## Setup

1. Install Node.js (version 14 or newer is recommended).
2. Clone the repository or copy the files.
3. Run `npm install` to install dependencies, including Playwright.
4. Ensure you have `BASE_URL` environment variable set to `https://www.saucedemo.com` or modify in `playwright.config.js`.

## Running Tests

Run tests with:
```
npx playwright test
```

## Notes
- Tests run on Chrome browser.
- Screenshots, videos, and traces are kept only on failure for debugging.
- Tests cover login with valid credentials, invalid credentials, empty fields, locked-out users, and password masking.

## References
- [Playwright Documentation](https://playwright.dev)
- [SauceDemo Application](https://www.saucedemo.com)