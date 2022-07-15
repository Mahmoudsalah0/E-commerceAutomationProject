@smoke
Feature: F01_Register | User could register with new account

  Scenario: guest user could register with valid data successfully

    Given  user navigate to register page
    And    user choose the gender
    When   user enter mandatory register data
    Then   user click on register button
    And    user could register successfully