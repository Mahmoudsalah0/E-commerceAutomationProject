@smoke

Feature: F02_Login | users could use login functionality to use their accounts

  Scenario: user login with valid email and password

    When   user navigate to login page
    And    user login with "salahmento@gmail.com" and "Aa123456"
    Then   user press on login button
    And    user login to the system successfully

  Scenario: user login with invalid email and password

    When   user navigate to login page
    And    user login with "salahmento@gmail.com" and "965231478"
    Then   user press on login button
    And    user could not login to the system