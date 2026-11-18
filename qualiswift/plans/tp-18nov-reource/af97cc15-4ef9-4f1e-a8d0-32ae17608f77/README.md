Qualiswift approved plan: TP_18NOV_GFASR
Version 2 · SHA-256 d26de0fd959a021bc9be6f391a6edf6f49ea73cf54f85b36bcf0ec1b111baf0b
1. Login with valid username and password
Case ID: TC-001
Story IDs: 128
Preconditions: User is on the login page of SauceDemo application.
1. Navigate to https://www.saucedemo.com/ on Chrome browser.
2. Enter username as 'standard_user'.
3. Enter password as 'secret_sauce'.
4. Click on the login button.
Step Expected: User should be successfully logged in and redirected to the Products page.
Test Data: Username: standard_user, Password: secret_sauce
Expected: User should be successfully logged in and redirected to the Products page.
2. Login with invalid username
Case ID: TC-002
Story IDs: 128
Preconditions: User is on the login page of SauceDemo application.
1. Navigate to https://www.saucedemo.com/ on Chrome browser.
2. Enter username as 'invalid_user'.
3. Enter password as 'secret_sauce'.
4. Click on the login button.
Step Expected: User should see an error message indicating the username is invalid and remain on the Login page.
Test Data: Username: invalid_user, Password: secret_sauce
Expected: User should see an error message indicating the username is invalid and remain on the Login page.
3. Login with invalid password
Case ID: TC-003
Story IDs: 128
Preconditions: User is on the login page of SauceDemo application.
1. Navigate to https://www.saucedemo.com/ on Chrome browser.
2. Enter username as 'standard_user'.
3. Enter password as 'invalid_password'.
4. Click on the login button.
Step Expected: User should see an error message indicating the password is invalid and remain on the Login page.
Test Data: Username: standard_user, Password: invalid_password
Expected: User should see an error message indicating the password is invalid and remain on the Login page.
4. Login with empty username and password fields
Case ID: TC-004
Story IDs: 128
Preconditions: User is on the login page of SauceDemo application.
1. Navigate to https://www.saucedemo.com/ on Chrome browser.
2. Leave username field empty.
3. Leave password field empty.
4. Click on the login button.
Step Expected: User should see an error message indicating that username and password fields cannot be empty and remain on the Login page.
Test Data: Username: '', Password: ''
Expected: User should see an error message indicating that username and password fields cannot be empty and remain on the Login page.
5. Login with empty username
Case ID: TC-005
Story IDs: 128
Preconditions: User is on the login page of SauceDemo application.
1. Navigate to https://www.saucedemo.com/ on Chrome browser.
2. Leave username field empty.
3. Enter password as 'secret_sauce'.
4. Click on the login button.
Step Expected: User should see an error message indicating that username cannot be empty and remain on the Login page.
Test Data: Username: '', Password: secret_sauce
Expected: User should see an error message indicating that username cannot be empty and remain on the Login page.
6. Login with empty password
Case ID: TC-006
Story IDs: 128
Preconditions: User is on the login page of SauceDemo application.
1. Navigate to https://www.saucedemo.com/ on Chrome browser.
2. Enter username as 'standard_user'.
3. Leave password field empty.
4. Click on the login button.
Step Expected: User should see an error message indicating that password cannot be empty and remain on the Login page.
Test Data: Username: standard_user, Password: ''
Expected: User should see an error message indicating that password cannot be empty and remain on the Login page.
7. Login attempt by locked-out user
Case ID: TC-007
Story IDs: 128
Preconditions: User is on the login page of SauceDemo application.
1. Navigate to https://www.saucedemo.com/ on Chrome browser.
2. Enter username as 'locked_out_user'.
3. Enter password as 'secret_sauce'.
4. Click on the login button.
Step Expected: User should see an error message indicating the account is locked and remain on the Login page.
Test Data: Username: locked_out_user, Password: secret_sauce
Expected: User should see an error message indicating the account is locked and remain on the Login page.
8. Password input masking verification
Case ID: TC-008
Story IDs: 128
Preconditions: User is on the login page of SauceDemo application.
1. Navigate to https://www.saucedemo.com/ on Chrome browser.
2. Enter any password in the password field (e.g., 'secret_sauce').
Step Expected: Password characters should be masked (hidden) while typing in the password field.
Test Data: Password: secret_sauce
Expected: Password characters should be masked (hidden) while typing in the password field.
9. Login with problem_user credentials
Case ID: TC-009
Story IDs: 128
Preconditions: User is on the login page of SauceDemo application.
1. Navigate to https://www.saucedemo.com/ on Chrome browser.
2. Enter username as 'problem_user'.
3. Enter password as 'secret_sauce'.
4. Click on the login button.
Step Expected: User should be successfully logged in and redirected to the Products page.
Test Data: Username: problem_user, Password: secret_sauce
Expected: User should be successfully logged in and redirected to the Products page.
10. Login with performance_glitch_user credentials
Case ID: TC-010
Story IDs: 128
Preconditions: User is on the login page of SauceDemo application.
1. Navigate to https://www.saucedemo.com/ on Chrome browser.
2. Enter username as 'performance_glitch_user'.
3. Enter password as 'secret_sauce'.
4. Click on the login button.
Step Expected: User should be successfully logged in and redirected to the Products page, accounting for any expected performance delay.
Test Data: Username: performance_glitch_user, Password: secret_sauce
Expected: User should be successfully logged in and redirected to the Products page, accounting for any expected performance delay.
