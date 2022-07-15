@smoke
Feature: F03_ChangeCurrency | user can change the currency [$, €]

  Scenario: guest user can choose € currency

    When     user select “Euro” from currency dropdown list
    Then     All Dollar sign $ change to euro sign €