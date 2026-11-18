# SauceDemo Login Tests

This project contains Playwright tests in JavaScript for the SauceDemo application's login scenarios.

## Setup

1. Install Node.js if not already installed.
2. Clone this repository.
3. Navigate to the project directory.
4. Run `npm install` to install dependencies.

## Running Tests

Set the environment variable `BASE_URL` to `https://www.saucedemo.com` or modify the baseURL in `playwright.config.js`.

Run tests with:

```bash
npx playwright test
```

Artifacts (screenshots, videos, traces) are retained on test failure.

## Files

- `playwright.config.js`: Playwright configuration file.
- `tests/qualiswift.spec.js`: Test scripts including page object models and test cases.

## Notes

- Tests assume Chrome browser usage (Chromium in Playwright).
- Password fields are tested for masking.
- Error messages are tested for visibility; exact text validation omitted due to missing specification.
- Tests cover valid and invalid login scenarios as per requirements.
