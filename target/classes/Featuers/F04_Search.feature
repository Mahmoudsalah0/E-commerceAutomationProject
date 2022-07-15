@smoke
Feature: F04_Search | user will be able to search for products with different parameters


  Scenario: user could search using "Product Name"

    Given user click on search bar
    When  user search for product like "Samsung"
    And   user click on the search Button
    Then  user could search successfully and go to search result


  Scenario: user search using "SKU"

    Given   user click on search bar
    When    user search for product like "M8_HTC_5L"
    And     user click on the search Button
    Then    user could search successfully with SKU


  Scenario: user search using invalid "product name"

    Given   user click on search bar
    When    user search for product like "Crocs"
    And     user click on the search Button
    Then    user could not search