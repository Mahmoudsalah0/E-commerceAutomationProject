@smoke
Feature: F05_HoverCategories  |  user could hover on categories and select one from them

  Scenario: user could hover categories

    When    user hover category and select subcategory
    And     user click on subcategory
    Then    user go to relative product page

